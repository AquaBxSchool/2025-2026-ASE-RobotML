			void main() {
				let a1 : boolean = 5.1 < 5
				let b1 : boolean = 5 < 5.1
				let c1 : boolean = 5 < 5
				let e1 : boolean = 5.1 < 5.1
				let f1 : boolean = e1 < e1
				let g1 : boolean = e1 < c1

				let a2 : boolean = 5.1 > 5
				let b2 : boolean = 5 > 5.1
				let c2 : boolean = 5 > 5
				let e2 : boolean = 5.1 > 5.1
				let f2 : boolean = e2 > e2
				let g2 : boolean = e2 > c2

				let a3 : boolean = 5.1 <= 5
				let b3 : boolean = 5 <= 5.1
				let c3 : boolean = 5 <= 5
				let e3 : boolean = 5.1 <= 5.1
				let f3 : boolean = e3 <= e3
				let g3 : boolean = e3 <= c3

				let a4 : boolean = 5.1 >= 5
				let b4 : boolean = 5 >= 5.1
				let c4 : boolean = 5 >= 5
				let e4 : boolean = 5.1 >= 5.1
				let f4 : boolean = e4 >= e4
				let g4 : boolean = e4 >= c4
			}