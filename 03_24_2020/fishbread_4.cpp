#include <iostream>

class Fishbread{
    public:
        void SetCost() const;
    private:
        int cost;    
};

// memeber �Լ��� const�� ���� ���� ���� �ٿ�����
void Fishbread::SetCost() const{
    cost = 500; // error
}