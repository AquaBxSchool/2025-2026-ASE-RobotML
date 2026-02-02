string bar() {
    return "bar"
}

boolean foo(val: integer) {
    val = 10
    return "bar" == bar()
}

integer main() {
    Forward( 10 )
    //Leftward( 10 )
    Rotate( 10 )
    // let t : boolean = foo() == true
    return 0
}
