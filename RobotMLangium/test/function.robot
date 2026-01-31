string bar() {
    return "bar"
}

boolean foo(void2: void, int: integer) {
    int = 10
    return "bar" == bar()
}

void main() {
    Forward( 10 )
    //Leftward( 10 )
    Rotate( 10 )
    return foo() == true
}
