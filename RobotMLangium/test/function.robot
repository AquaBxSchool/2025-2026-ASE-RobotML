string bar() {
    return "bar"
}

boolean foo(val: integer) {
    val = 10
    return "bar" == bar()
}

integer main() {
    SetSpeed( 20 )
    Move( Forward, 10. )
    Move( Left, 10 )
    Rotate( 10 )
    let t : boolean = foo(1) == true
    return 0
}
