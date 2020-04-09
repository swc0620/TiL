#include "Checking.h"
#include <iostream>

using namespace std;

Checking::Checking(int num, float bal, float min, float chg) : BankAccount(num, bal){
    this->acctnum = num;
    this->bal = bal;
    this->minimum = min;
    this->charge = chg;
}

int Checking::withdraw(float amount){
    if (bal <= amount){
        cout << "Cannot withdraw $" << amount << " on account #" << acctnum << " because the balance is low." << endl;
        return 0;
    } else{
        if (bal < minimum){
            bal = bal - amount - charge;
            return 1;
        } else {
            bal = bal - amount;
            return 1;
        }
    }
}

void Checking::print(){
    cout << "Checking Account: " << acctnum << endl;
    cout << "        " << "Balance: " << bal << endl;
    cout << "        " << "Minimum to Avoid Charges: " << minimum << endl;
    cout << "        " << "Charge per Check: " << charge << endl;
    cout << endl;
}