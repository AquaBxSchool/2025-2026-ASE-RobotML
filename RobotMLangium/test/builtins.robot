void main() {
    let d = 10
    SetSpeed(d)
    SetClock(d)
    Move( Forward, d)
    Move( Left, d)
    Move( Left, true)
    Move( Right, d)
    Move( Backward, d)
    Move( LowerLeft, d)
    Move( UpperRight, d)
    Move( UpperLeft, d)
    Move( LowerRight, d)
    Rotate(-d)
    let _ = GetSensor(Distance)
    let _ = GetClock()
    let s: float = GetSpeed()
    SetSpeed(s)
}
