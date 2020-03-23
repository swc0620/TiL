#include <iostream>

using namespace std;

int main(void) {

    int* ptr;
    int var = 7; // address of var = 0xA
    int foo = 21; // address of foo = 0xB
    ptr = &var; // value stored inside the pointer(ptr) becomes the address of var(0xA)
    cout << *ptr << endl; // prints out the reference value of the pointer(ptr) which is 7
    ptr = &foo;
    cout << *ptr << endl;

    int& ref = var; // unlike pointer(ptr) the reference(ref) cannot be moved to point foo

    return 0;
}