#include <iostream>

using namespace std;

class A {
    public:
        virtual void pr() {
            cout << "base" << endl;
        }
        int num;
};

class B: public A {
    public:
        void pr() {
            cout << "derived" << endl;
        }
        int num = 5;
};

main() {
    B b;
    A a = b;
    // A &c = b;
    // A *pA = &b;
    // a.pr();
    // c.pr();
    // pA->pr();
    cout << a.num << endl;
}