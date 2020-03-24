#include <iostream>

using std::cout;
using std::endl;

int func(int a = 0){
    return a + 1;
}

int main(void){
    cout << func(11) << endl;
    cout << func() << endl;
    return 0;
}