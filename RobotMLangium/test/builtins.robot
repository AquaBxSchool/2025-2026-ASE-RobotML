void main() {
    let d = 10
    setSpeed(d)
    SetClock(d)
    Backward(d)
    Forward(d)
    Rightward(d)
    Leftward(d)
    Rotate(-d)
    let _ = GetSensor(Distance)
    let _ = GetClock()
    let s: float = GetSpeed()
    setSpeed(s)
}
