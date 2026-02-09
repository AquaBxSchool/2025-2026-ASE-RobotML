string bar() {
    return "bar"
}

boolean foo(val: integer) {
    val = 10
    return "bar" == bar()
}

integer main() {
    SetSpeed( 20 millimeter/second )
    Move( Forward 10 millimeter )
    Move( Left 10 millimeter )
    Rotate( 10 in boolean degrees )
    let t : boolean = foo(1) == true
    return 0
}
