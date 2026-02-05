void main() {

    SetSpeed(30)

    let i = 0

    if (GetSensor(Distance) > 100) {
        Move(Forward, 100)
    }
    else {
        Rotate(90)
    }

    // while (i < 4) {
    //     Move(Forward, 300)
    //     i = i +1
    // }

}