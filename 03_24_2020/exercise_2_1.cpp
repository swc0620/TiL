#include <iostream>

using std::cout;
using std::endl;
using std::cin;

void swap(int *a, int *b);
void swap(char *a, char *b);

int main(void){
    int intvar1, intvar2;
    cout << "Put two members for swapping" << endl;
    cin >> intvar1 >> intvar2;
    swap(&intvar1, &intvar2);

    char charvar1, charvar2;
    cout << "Put two characters for swapping" << endl;
    cin >> charvar1 >> charvar2;
    swap(&charvar1, &charvar2);

    cout << "Results" << endl;
    cout << intvar1 << " " << intvar2 << endl;
    cout << charvar1 << " " << charvar2 << endl;
    
    return 0;
}

void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

void swap(char *a, char *b){
    char temp = *a;
    *a = *b;
    *b = temp;
}