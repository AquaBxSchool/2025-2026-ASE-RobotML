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
	it("general test", async () => {
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

	it("verify set speed", async () => {
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

		expect(generated).equal(expected);
	});

	it("verify get speed", async () => {
		const code = `
        void main() {
            let _ = GetSpeed(millimeter, millisecond)
            let _ = GetSpeed(millimeter, second)
            let _ = GetSpeed(millimeter, minute)

			let _ = GetSpeed(centimeter, millisecond)
            let _ = GetSpeed(centimeter, second)
            let _ = GetSpeed(centimeter, minute)

			let _ = GetSpeed(decimeter, millisecond)
            let _ = GetSpeed(decimeter, second)
            let _ = GetSpeed(decimeter, minute)

			let _ = GetSpeed(meter, millisecond)
            let _ = GetSpeed(meter, second)
            let _ = GetSpeed(meter, minute)
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
float _ = speed * 0.001;
float _ = speed * 1;
float _ = speed * 60;
float _ = speed * 0.0001;
float _ = speed * 0.1;
float _ = speed * 6;
float _ = speed * 0.00001;
float _ = speed * 0.01;
float _ = speed * 0.6;
float _ = speed * 0.000001;
float _ = speed * 0.001;
float _ = speed * 0.06;

}`;

		expect(generated).equal(expected);
	});

	it("verify get speed", async () => {
		const code = `
        void main() {
            Rotate(90, degrees)
            Rotate(-90, radians)
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
rotate(Omni,90 * PI / 180);
rotate(Omni,- 90 * 1);

}`;

		expect(generated).equal(expected);
	});

	it("verify delay", async () => {
		const code = `
        void main() {
            Delay(1, millisecond)
            Delay(1, second)
            Delay(1, minute)
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
delay((int)1 * 1);
delay((int)1 * 1000);
delay((int)1 * 60000);

}`;

		expect(generated).equal(expected);
	});

	it("verify distance", async () => {
		const code = `
        void main() {
            let _ = GetDistance(millimeter)
			let _ = GetDistance(centimeter)
			let _ = GetDistance(decimeter)
            let _ = GetDistance(meter)
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
float _ = getDistance() / 1;
float _ = getDistance() / 10;
float _ = getDistance() / 100;
float _ = getDistance() / 1000;

}`;

		expect(generated).equal(expected);
	});
});
