// C++ header file
#include <iostream>
#include <string>

using std::string;

class Fishbread{
    public:
        Fishbread();
        Fishbread(int argCost, string argCtent);
        ~Fishbread();
        int getCost();
        void setCost(int c);
    private:
        int cost;
        string content;    
};