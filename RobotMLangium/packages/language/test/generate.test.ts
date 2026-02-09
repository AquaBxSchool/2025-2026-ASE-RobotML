import { EmptyFileSystem } from "langium";
import { parseHelper } from "langium/test";
import type { RobotML } from "robot-ml-language/semantics";
import { beforeEach, describe, expect, it } from "vitest";
import { createRobotMlServices, RobotMlServices } from "../src/";

let services: RobotMlServices;
let parse: ReturnType<typeof parseHelper<RobotML>>;

beforeEach(async () => {
	services = createRobotMlServices(EmptyFileSystem).RobotMl;

	parse = parseHelper(services);
});

describe("Parsing tests", () => {
	it("should fail on empty input", async () => {
		const code = `
        void main() {
            SetSpeed(30, millimeter, second)
            let i = 0
            if (GetDistance(centimeter) > 10) {
                Move(Forward, 10, centimeter)
            }
            else {
                Rotate(90, degrees)
            }
        }
        `;

		const result = await parse(code, { validation: true });

		const model: RobotML = result.parseResult?.value;
		const functionDeclaration = model.accept(
			services.visitors.RobotMLFunctionPass,
		);
		const generatorVisitor = services.visitors.RobotMLGeneratorVisitor;
		generatorVisitor.setFunctionDec(functionDeclaration);

		let generated = model.accept(generatorVisitor);

		const expected = `int main_(  ) 
{
speed = 30 * 1;
int i = 0;
if (getDistance() / 10 > 10) {
forward(Omni, 10 * 10);

}else {
rotate(Omni,90 * PI / 180);

};

}`;

		expect(generated).equal(expected);
	});
});
