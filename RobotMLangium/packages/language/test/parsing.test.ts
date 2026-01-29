import { EmptyFileSystem } from "langium";
import { parseHelper } from "langium/test";
import type { RobotML } from "robot-ml-language/semantics";
import { beforeEach, describe, expect, it } from "vitest";
import { createRobotMlServices } from "../src/";

let services: ReturnType<typeof createRobotMlServices>;
let parse: ReturnType<typeof parseHelper<RobotML>>;

beforeEach(async () => {
	services = createRobotMlServices(EmptyFileSystem);
	parse = parseHelper(services.RobotMl);
});

describe("Parsing tests", () => {
	it("should fail on empty input", async () => {
		const code = ``;

		const result = await parse(code, { validation: true });

		expect(result.diagnostics?.length).equal(1);
		expect(result.diagnostics?.[0]?.message).equal(
			"There is no main functions defined",
		);
	});

	it("builtins", async () => {
		const code = `
		void main() {
		    let d = 10
        let d2 = 10.1
        setSpeed(d)
        SetClock(d)
        Backward(d)
        Forward(d)
        Rightward(d)
        Leftward(d)
        Rotate(-d)
        setSpeed(d2)
        SetClock(d2)
        Backward(d2)
        Forward(d2)
        Rightward(d2)
        Leftward(d2)
        Rotate(-d2)
        let _ = GetSensor(Distance)
        let _ = GetClock()
        let s: float = GetSpeed()
        setSpeed(s)
    }
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(0);
  });

	it("builtinsErr", async () => {
		const code = `
		void main() {
        let d = true
        setSpeed(d)
        SetClock(d)
        Backward(d)
        Forward(d)
        Rightward(d)
        Leftward(d)
        Rotate(-d)
        let _ : string = GetSensor(Distance)
        let _ : string = GetClock()
        let s: string = GetSpeed()
        setSpeed(s)
    }
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(12);
	});

	it("Add an int to a float", async () => {
		const code = `
			void main() {
				let a : integer = 5
				let b : float = 5.1 + a
			}
		`;
		const result = await parse(code, { validation: true });
		console.log(result.diagnostics);

		expect(result.diagnostics?.length).equal(0);
	});

	it("Add a int to a bool", async () => {
		const code = `
			void main() {
				let a : integer = 5
				let b : boolean = true + a
			}
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(1);
		expect(result.diagnostics?.[0]?.message).equal(
			"Could not add a boolean to a integer [object Object]",
		);
  });

	it("Ingnore Variable", async () => {
		const code = `
			void main() {
				let _a : integer = 5
				let b = _a
			}
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.filter((d) => d.severity === 1).length).equal(1);
		expect(result.diagnostics?.[0]?.message).equal(
			"Variable _a does not exist",
		);
  });

	it("Decl then assignation", async () => {
		const code = `
			void main() {
				let a_: integer
				a_ = 10
			}
		`;
		const result = await parse(code, { validation: true });
		console.log(result.diagnostics)
		expect(result.diagnostics?.filter((d) => d.severity === 1).length).equal(0);
		// expect(result.diagnostics?.[0]?.message).equal(
		// 	"Variable _a does not exist",
		// );
	});

	it("controlflow", async () => {
		const code = `
			integer main(int: integer) {
				let c: integer = 0

				while (c <= 10)  {
   					c = c + 1
				}

				if ( int == 1 ) {
	  				return 1
				} elif ( int == 2 ) {
					return 2
				} else {
	  				return 3
				}
			}
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(0);
	});

	it("function", async () => {
		const code = `
      string bar() {
          return "bar"
      }
      boolean foo(void2: void, int: integer) {
          int = 10
          return "bar" == bar()
      }
  		void main() {
          return foo() == true
      }
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(0);
	});
	it("math", async () => {
		const code = `
      integer main() {
              let b: integer = 9
              let a: integer = -10
              let c: integer = a / 1
              let _ = b * 1
              let _ = c - 1
              let _ = c + 1
              let _ = c == 1
              let _ = c <= 1
              let _ = c >= 1
              let _ = c != 1
              let _ = c < 1
              let _ = c > 1
              let _ = c == c && 1 == 1
              let _ = c == c || 1 == 1
              let _ = c ^ 1
              let c = ((10 * (12 + 4 + b) == 20) || a < b / b)

              return c
          }
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(0);
	});
});
