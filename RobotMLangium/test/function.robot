string bar() {
    return "bar"
}

boolean foo(void2: void, int: integer) {
    return "bar" == bar()
}

void main() {
    return foo() == true
}
