#include "Fishbread.h"
using std::cout;
using std::endl;

Fishbread::Fishbread(){}

Fishbread::Fishbread(int argCost, string argContent){
    cost = argCost;
    content = argContent;
}

Fishbread::~Fishbread(){
    cout << "we finish eating the <"+content+"> fishbread" << endl;
}

int Fishbread::getCost(){
    return cost;
}

void Fishbread::setCost(int c){
    cost = c;
}