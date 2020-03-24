#include <iostream>
#include <string>

using namespace std;

class Fishbread{
    private:
        int cost;
        int seller;
        string content;
        int roasting;
    public:
        int GetCost(){
            return cost;
        }
        void SetCost(int c){
            cost = c;
        }    
};

int main(void){
    Fishbread fish1;
    fish1.SetCost(500);
    cout << "Price? " << fish1.GetCost() << endl;
    fish1.SetCost(700);
    cout << "Price? " << fish1.GetCost() << endl;
}