#include <iostream>

void function (void){
    std::cout << "function(void) call" << std::endl;
}
void function(int a, int b){
    std::cout << "function("<<a<<","<<b<<") call" << std::endl;
}
int main(void){
    function(); 
    function(12, 13);
    return 0;
}