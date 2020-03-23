#include <iostream>

using namespace std;

class A {  
    public:
        void pr() {
            cout << "base" << endl;
        }
};        


class B: public A {
    public:
        void pr() {
            cout << "derived" << endl;
        }
};

main() {
    B b;
    A a;
    A *pA = &b;
    a.pr();
    pA->pr();
    b.pr();
}