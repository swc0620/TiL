#include "BankSystem.h"
#include <iostream>

using namespace std;

void BankSystem::transaction(BankAccount* from, BankAccount* to, float amount){
    int result;
    result = from->withdraw(amount + 10);
    if (result == 1){
        to->deposit(amount);
    }
}

void BankSystem::deposit(BankAccount* b, float amount){
    b->deposit(amount);
}

void BankSystem::withdraw(BankAccount* b, float amount){
    b->withdraw(amount);
}