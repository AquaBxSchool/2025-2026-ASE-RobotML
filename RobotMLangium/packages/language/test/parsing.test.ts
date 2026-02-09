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
	       SetSpeed(d,millimeter / second)
	       Move(Backward,d,millimeter)
	       Move(Forward,d,millimeter)
	       Move(Right,d,millimeter)
	       Move(Left,d,millimeter)
	       Rotate(-d,degrees)
	       SetSpeed(d2,millimeter / second)
	       Move(Backward,d2,millimeter)
	       Move(Forward,d2,millimeter)
	       Move(Right,d2,millimeter)
	       Move(Left,d2,millimeter)
	       Rotate(-d2,degrees)
	       let _ = GetDistance(millimeter)
	       let s: float = GetSpeed(millimeter / second)
	       SetSpeed(s,millimeter / second)
	   }
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(0);
	});

	it("builtinsErr", async () => {
		const code = `
		void main() {
	       let d = true
	       SetSpeed(d, millimeter / second)
	       Move(Backward,d, millimeter)
	       Move(Forward,d, millimeter)
	       Move(Right,d, millimeter)
	       Move(Left,d, millimeter)
	       Rotate(-d,degrees)
	       let _ : string = GetDistance(millimeter)
	       let s: string = GetSpeed(millimeter / second)
	       SetSpeed(s,millimeter / second)
	   }
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(10);
	});

	it("Authorized additions", async () => {
		const code = `
			void main() {
				let a : float = 5.1 + 5
				let b : float = 5 + 5.1
				let c : integer = 5 + 5
				let d : string = "5" + "5"
				let e : float = 5.1 + 5.1
				let f : float = e + e
				let g : float = e + c
			}
		`;
		const result = await parse(code, { validation: true });

		expect(result.diagnostics?.length).equal(0);
	});

	it("Authorized Equality", async () => {
		const code = `
			void main() {
				let a : boolean = 5 == 5
				let b : boolean = 5 != 6

				let c : boolean = "5" == "5"
				let d : boolean = "5" != "6"

				let e : boolean = 5.1 == 5.1
				let f : boolean = 5.1 != 6.1

				let g : boolean = 5 == 6.1
				let h : boolean = 5 != 6.1

				let i : boolean = true == true
				let j : boolean = false != true
			}
		`;
		const result = await parse(code, { validation: true });

		expect(result.diagnostics?.length).equal(0);
	});

	it("Unauthorized Equality", async () => {
		const code = `
			void main() {
				let a1 : boolean = "5.1" == 5
				let b1 : boolean = 5 != "5.1"
				let c1 : boolean = 5.1 == "5"
				let d1 : boolean = "5" != 5.1

				let a2 : boolean = true == 5
				let b2 : boolean = 5 != true
				let c2 : boolean = 5.1 == true
				let d2 : boolean = false != 5.1

			}
		`;
		const result = await parse(code, { validation: true });

		expect(result.diagnostics?.length).equal(8);

		expect(result.diagnostics?.[0]?.message).equal(
			"Could not apply the operation == between a string and a integer [object Object]",
		);
		expect(result.diagnostics?.[1]?.message).equal(
			"Could not apply the operation != between a integer and a string [object Object]",
		);

		expect(result.diagnostics?.[2]?.message).equal(
			"Could not apply the operation == between a float and a string [object Object]",
		);
		expect(result.diagnostics?.[3]?.message).equal(
			"Could not apply the operation != between a string and a float [object Object]",
		);

		expect(result.diagnostics?.[4]?.message).equal(
			"Could not apply the operation == between a boolean and a integer [object Object]",
		);
		expect(result.diagnostics?.[5]?.message).equal(
			"Could not apply the operation != between a integer and a boolean [object Object]",
		);

		expect(result.diagnostics?.[6]?.message).equal(
			"Could not apply the operation == between a float and a boolean [object Object]",
		);
		expect(result.diagnostics?.[7]?.message).equal(
			"Could not apply the operation != between a boolean and a float [object Object]",
		);
	});

	it("Authorized arithmetic operations", async () => {
		const code = `
			void main() {
				let a1 : float = 5.1 - 5
				let b1 : float = 5 - 5.1
				let c1 : integer = 5 - 5
				let e1 : float = 5.1 - 5.1
				let f1 : float = e1 - e1
				let g1 : float = e1 - c1

				let a2 : float = 5.1 * 5
				let b2 : float = 5 * 5.1
				let c2 : integer = 5 * 5
				let e2 : float = 5.1 * 5.1
				let f2 : float = e2 * e2
				let g2 : float = e2 * c2

				let a3 : float = 5.1 / 5
				let b3 : float = 5 / 5.1
				let c3 : integer = 5 / 5
				let e3 : float = 5.1 / 5.1
				let f3 : float = e3 / e3
				let g3 : float = e3 / c3

				let a4 : float = 5.1 ^ 5
				let b4 : float = 5 ^ 5.1
				let c4 : integer = 5 ^ 5
				let e4 : float = 5.1 ^ 5.1
				let f4 : float = e4 ^ e4
				let g4 : float = e4 ^ c4
			}
		`;
		const result = await parse(code, { validation: true });

		expect(result.diagnostics?.length).equal(0);
	});

	it("Unauthorized arithmetic operations", async () => {
		const code = `
			void main() {
				let a1 : float = "5.1" * 5
				let b1 : float = 5 - "5.1"
				let c1 : float = 5.1 / "5"
				let d1 : float = "5" ^ 5.1

				let a2 : float = true * 5
				let b2 : float = 5 - true
				let c2 : float = 5.1 / true
				let d2 : float = false ^ 5.1
			}
		`;
		const result = await parse(code, { validation: true });

		expect(result.diagnostics?.length).equal(8);

		expect(result.diagnostics?.[0]?.message).equal(
			"Could not apply the operation * between a string and a integer [object Object]",
		);
		expect(result.diagnostics?.[1]?.message).equal(
			"Could not apply the operation - between a integer and a string [object Object]",
		);

		expect(result.diagnostics?.[2]?.message).equal(
			"Could not apply the operation / between a float and a string [object Object]",
		);
		expect(result.diagnostics?.[3]?.message).equal(
			"Could not apply the operation ^ between a string and a float [object Object]",
		);

		expect(result.diagnostics?.[4]?.message).equal(
			"Could not apply the operation * between a boolean and a integer [object Object]",
		);
		expect(result.diagnostics?.[5]?.message).equal(
			"Could not apply the operation - between a integer and a boolean [object Object]",
		);

		expect(result.diagnostics?.[6]?.message).equal(
			"Could not apply the operation / between a float and a boolean [object Object]",
		);
		expect(result.diagnostics?.[7]?.message).equal(
			"Could not apply the operation ^ between a boolean and a float [object Object]",
		);
	});

	it("Authorized comparaisons", async () => {
		const code = `
			void main() {
				let a1 : boolean = 5.1 < 5
				let b1 : boolean = 5 < 5.1
				let c1 : boolean = 5 < 5
				let e1 : boolean = 5.1 < 5.1

				let a2 : boolean = 5.1 > 5
				let b2 : boolean = 5 > 5.1
				let c2 : boolean = 5 > 5
				let e2 : boolean = 5.1 > 5.1

				let a3 : boolean = 5.1 <= 5
				let b3 : boolean = 5 <= 5.1
				let c3 : boolean = 5 <= 5
				let e3 : boolean = 5.1 <= 5.1

				let a4 : boolean = 5.1 >= 5
				let b4 : boolean = 5 >= 5.1
				let c4 : boolean = 5 >= 5
				let e4 : boolean = 5.1 >= 5.1
			}
		`;
		const result = await parse(code, { validation: true });

		expect(result.diagnostics?.length).equal(0);
	});

	it("Unauthorized comparaisons", async () => {
		const code = `
			void main() {
				let a1 : boolean = "5.1" < 5
				let b1 : boolean = 5 <= "5.1"
				let c1 : boolean = 5.1 > "5"
				let d1 : boolean = "5" >= 5.1

				let a2 : boolean = true < 5
				let b2 : boolean = 5 <= true
				let c2 : boolean = 5.1 > true
				let d2 : boolean = false >= 5.1
			}
		`;
		const result = await parse(code, { validation: true });

		expect(result.diagnostics?.length).equal(8);

		expect(result.diagnostics?.[0]?.message).equal(
			"Could not apply the operation < between a string and a integer [object Object]",
		);
		expect(result.diagnostics?.[1]?.message).equal(
			"Could not apply the operation <= between a integer and a string [object Object]",
		);

		expect(result.diagnostics?.[2]?.message).equal(
			"Could not apply the operation > between a float and a string [object Object]",
		);
		expect(result.diagnostics?.[3]?.message).equal(
			"Could not apply the operation >= between a string and a float [object Object]",
		);

		expect(result.diagnostics?.[4]?.message).equal(
			"Could not apply the operation < between a boolean and a integer [object Object]",
		);
		expect(result.diagnostics?.[5]?.message).equal(
			"Could not apply the operation <= between a integer and a boolean [object Object]",
		);

		expect(result.diagnostics?.[6]?.message).equal(
			"Could not apply the operation > between a float and a boolean [object Object]",
		);
		expect(result.diagnostics?.[7]?.message).equal(
			"Could not apply the operation >= between a boolean and a float [object Object]",
		);
	});

	it("Authorized boolean operations", async () => {
		const code = `
			void main() {
				let a : boolean = false && true
				let b : boolean = true || false
				let c : boolean = a && b
				let d : boolean = a || b
			}
		`;
		const result = await parse(code, { validation: true });

		expect(result.diagnostics?.length).equal(0);
	});

	it("Unauthorized boolean operations", async () => {
		const code = `
			void main() {
				let a1 : boolean = "5.1" && 5
				let b1 : boolean = 5 || "5.1"
				let c1 : boolean = 5.1 && "5"
				let d1 : boolean = "5" || 5.1

				let a2 : boolean = true && 5
				let b2 : boolean = 5 || true
				let c2 : boolean = 5.1 && true
				let d2 : boolean = false || 5.1

				let a3 : boolean = 5.1 || 5.1
			}
		`;
		const result = await parse(code, { validation: true });

		expect(result.diagnostics?.length).equal(9);

		expect(result.diagnostics?.[0]?.message).equal(
			"Could not apply the operation && between a string and a integer [object Object]",
		);
		expect(result.diagnostics?.[1]?.message).equal(
			"Could not apply the operation || between a integer and a string [object Object]",
		);

		expect(result.diagnostics?.[2]?.message).equal(
			"Could not apply the operation && between a float and a string [object Object]",
		);
		expect(result.diagnostics?.[3]?.message).equal(
			"Could not apply the operation || between a string and a float [object Object]",
		);

		expect(result.diagnostics?.[4]?.message).equal(
			"Could not apply the operation && between a boolean and a integer [object Object]",
		);
		expect(result.diagnostics?.[5]?.message).equal(
			"Could not apply the operation || between a integer and a boolean [object Object]",
		);

		expect(result.diagnostics?.[6]?.message).equal(
			"Could not apply the operation && between a float and a boolean [object Object]",
		);
		expect(result.diagnostics?.[7]?.message).equal(
			"Could not apply the operation || between a boolean and a float [object Object]",
		);

		expect(result.diagnostics?.[8]?.message).equal(
			"Could not apply the operation || between a float and a float [object Object]",
		);
	});

	it("Add a int to a bool", async () => {
		const code = `
			void main() {
				let truc : void
				let a = true + truc
				let b = truc + true

				let c = truc + truc
				let d = true + true

				let e : string = "true" + 5
			}
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(5);
		expect(result.diagnostics?.[0]?.message).equal(
			"Could not add a boolean to a void [object Object]",
		);
		expect(result.diagnostics?.[1]?.message).equal(
			"Could not add a void to a boolean [object Object]",
		);

		expect(result.diagnostics?.[2]?.message).equal(
			"Could not add a void to a void [object Object]",
		);
		expect(result.diagnostics?.[3]?.message).equal(
			"Could not add a boolean to a boolean [object Object]",
		);

		expect(result.diagnostics?.[4]?.message).equal(
			"Could not add a string to a integer [object Object]",
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
		expect(result.diagnostics?.filter((d) => d.severity === 1).length).equal(
			1,
		);
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
		expect(result.diagnostics?.filter((d) => d.severity === 1).length).equal(
			0,
		);
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
	it("cast", async () => {
		const code = `
		void main() {
	       let bf = true
	       let bt = bf
	       let _ = 10 in boolean == false
	       let _ = bf in float == 0.0
	       let _ = bf in integer == 0
	       let _ = bf in boolean == true
	       let _ = bf in float == 1
	       let _ = bf in integer == 1

	       let u = -230
	       let _ = u in boolean == 1
	       let _ = u in float == -230.0

	       let i = 20
	       let _ = i in boolean == 1
	       let _ = i in float == 20.

	       let f = 10.
	       let _ = f in boolean == 1
	       let _ = f in integer == 10
	       let _ = f in float == 10.

	       let fh1 = 10.5
	       let _ = fh1 in integer == 10

	       let fh2 = 10.6
	       let _ = fh2 in integer == 11

	       let fh3 = 10.3
	       let _ = fh3 in integer == 10

	       let oi = 0
	       let _ = oi in boolean == 0

	       let of = 0.0
	       let _ = of in boolean == 0
	   }
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(0);
	});

	it("scope", async () => {
		const code = `
		void main() {
	     let _errror = value + 1
	     let value = 10
	   }
		`;
		const result = await parse(code, { validation: true });
		expect(result.diagnostics?.length).equal(3);
		expect(result.diagnostics?.[0]?.message).equal(
			"Variable value does not exist",
		);
	});
});
