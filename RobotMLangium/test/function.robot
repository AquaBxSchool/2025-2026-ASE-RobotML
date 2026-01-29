string bar() {
    return "bar"
}

boolean foo(void2: void, int: integer) {
    int = 10
    return "bar" == bar()
}

void main() {
    return foo() == true
}
