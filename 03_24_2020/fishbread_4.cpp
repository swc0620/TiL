#include <iostream>

class Fishbread{
    public:
        void SetCost() const;
    private:
        int cost;    
};

// memeber 함수에 const를 붙일 때는 끝에 붙여야함
void Fishbread::SetCost() const{
    cost = 500; // error
}