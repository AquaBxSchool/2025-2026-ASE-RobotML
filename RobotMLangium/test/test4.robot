		void main() {
	       let d = true
	       SetSpeed(d, millimeter, second)
	       Move(Backward,d, millimeter)
	       Move(Forward,d, millimeter)
	       Move(Right,d, millimeter)
	       Move(Left,d, millimeter)
	       Rotate(-d,degrees)
	       let _ : string = GetDistance(millimeter)
	       let s: string = GetSpeed(millimeter,second)
	       SetSpeed(s,millimeter,second)
	   }