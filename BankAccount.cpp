#include "BankAccount.h"

using namespace std;

BankAccount::BankAccount(int num, float bal){
    this->acctnum = num;
    this->bal = bal;
}

void BankAccount::deposit(float amount){
    bal = bal + amount;
}

int BankAccount::withdraw(float amount){
    bal = bal - amount;
}

int BankAccount::getAcctnum(){
    return acctnum;
}

float BankAccount::getBalance(){
    return bal;
}