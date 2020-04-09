#include "InterestChecking.h"
#include <iostream>

using namespace std;

InterestChecking::InterestChecking(int num, float bal, float cmin, float imin, float chg, float rate, float monchg){
    this->acctnum = num;
    this->bal = bal;
    this->minimum = cmin;
    this->minint = imin;
    this->charge = chg;
    this->intrate = rate;
    this->moncharge = monchg;
}

void InterestChecking::interest(){
    if (bal >= minint){
        bal = bal + ((bal * intrate) / 1200);
    } else {
        bal = bal - moncharge;
    }
}

void InterestChecking::print(){
    cout << "Interest Checking Account: " << acctnum << endl;
    cout << "        " << "Balance: " << bal << endl;
    cout << "        " << "Minimum to Avoid Charges: " << minimum << endl;
    cout << "        " << "Charge per Check: " << charge << endl;
    cout << "        " << "Minimum Balance for interest and No Monthly Fee: " << minint << endl;  
    cout << "        " << "Interest: " << intrate << "%" << endl;  
    cout << "        " << "Monthly Fee: " << moncharge << endl;
    cout << endl;      
}