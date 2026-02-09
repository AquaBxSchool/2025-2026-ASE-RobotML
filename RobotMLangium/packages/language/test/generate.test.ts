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
speed = 30 / 1;
int i = 0;
if (getDistance() / 10 > 10) {
forward(Omni, 10 * 10);

}else {
rotate(Omni,90 * PI / 180);

};

}`;

		expect(generated).equal(expected);
	});

	it("should fail on empty input", async () => {
		const code = `
        void main() {
            SetSpeed(30, millimeter, millisecond)
            SetSpeed(30, millimeter, second)
            SetSpeed(30, millimeter, minute)

			SetSpeed(30, centimeter, millisecond)
            SetSpeed(30, centimeter, second)
            SetSpeed(30, centimeter, minute)

			SetSpeed(30, decimeter, millisecond)
            SetSpeed(30, decimeter, second)
            SetSpeed(30, decimeter, minute)

			SetSpeed(30, meter, millisecond)
            SetSpeed(30, meter, second)
            SetSpeed(30, meter, minute)
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
speed = 30 / 0.001;
speed = 30 / 1;
speed = 30 / 60;
speed = 30 / 0.0001;
speed = 30 / 0.1;
speed = 30 / 6;
speed = 30 / 0.00001;
speed = 30 / 0.01;
speed = 30 / 0.6;
speed = 30 / 0.000001;
speed = 30 / 0.001;
speed = 30 / 0.06;

}`;
		console.log(generated);

		expect(generated).equal(expected);
	});
});
