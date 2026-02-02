string bar() {
    return "bar"
}

boolean foo(val: integer) {
    val = 10
    return "bar" == bar()
}

integer main() {
    setSpeed( 20 )
    Forward( 10 )
    Leftward( 10 )
    Rotate( 10 )
    let t : boolean = foo(1) == true
    return 0
}
