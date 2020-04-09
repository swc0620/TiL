#include "Savings.h"
#include <iostream>

using namespace std;

Savings::Savings(int num, float bal, float rate) : BankAccount(num, bal){
    this->acctnum = num;
    this->bal = bal;
    this->intrate = rate;
}

void Savings::interest(){
    bal = bal + ((bal * intrate) / 1200);
}

int Savings::withdraw(float amount){
    if (bal <= amount){
        cout << "Cannot withdraw $" << amount << " on account #" << acctnum << " because the balance is low." << endl;
        return 0;
    } else {
        bal = bal - amount;
        return 1;
    }
}

void Savings::print(){
    cout << "Savings Account: " << acctnum << endl;
    cout << "        " << "Balance: " << bal << endl;
    cout << "        " << "Interest: " << intrate << "%" << endl;
    cout << endl;
}