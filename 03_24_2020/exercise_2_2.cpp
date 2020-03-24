#include <iostream>

using namespace std;

int main(void){
    char alphabet;
    char new_alphabet;
    bool out = false;

    while(!out){
      cout << "Enter Capital or Small Letter(0 for exit):";
      cin >> alphabet;
      if (alphabet >= 'A' && alphabet <= 'Z'){
          cout << "input : " << alphabet << " ";
          new_alphabet = alphabet + 32;
          cout << "output : " << new_alphabet << endl;
      }
      else if (alphabet >= 'a' && alphabet <= 'z'){
          cout << "input : " << alphabet << " ";
          new_alphabet = alphabet - 32;
          cout << "output : " << new_alphabet << endl;
      }
      else if (alphabet == '0'){
          out = true;
      }
      else {
          cout << "Enter character" << endl;
      }
    };

    return 0;
}