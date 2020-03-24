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
        int GetCost();
        void SetCost(int argCost);
};

// method를 class 외부에서 정의할 수 있다.
int Fishbread::GetCost(){
    return cost;
}

void Fishbread::SetCost(int argCost){
    cost = argCost;
}

int main(void){
    Fishbread fish1;
    fish1.SetCost(100);
    cout << fish1.GetCost() << endl;
}