void main() {
    let d = 10
    SetSpeed(d)
    SetClock(d)
    Move( Advance, d)
    Move( Left, d)
    Move( Right, d)
    Move( Backoff, d)
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
