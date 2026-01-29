import { describe } from "vitest";
import { createRobotMlServices } from "../src/";
import type { RobotML } from "robot-ml-language/semantics";
import { parseHelper } from "langium/test";
import { EmptyFileSystem } from "langium";
import { beforeEach, expect, it } from "vitest";

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
		expect(result.diagnostics![0]!.message).equal(
			"There is no main functions defined",
		);
	});

	it("builtins", async () => {
		const code = `
  		void main() {
          let _ = GetSensor(Distance)
          let _ = GetClock()
          let s: float = GetSpeed()
          setSpeed(s)
      }
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(0);
	});

	it("Add an int to a float", async () => {
		const code = `
			void main() {
				let a : integer = 5
				let b : float = 5.0 + a
			}
		`;
		const result = await parse(code, { validation: true });
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
		expect(result.diagnostics![0]!.message).equal(
			"Could not add a boolean to a integer [object Object]",
		);
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
