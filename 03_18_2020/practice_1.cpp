#include <iostream>
#include <string>

using namespace std;

class Item {
    public:
        string title;
        double price;
        double SalePrice() {
            return price * 0.9;
        };
        int isAvailable() {
            return inStockQuantity > 0 ? 1 : 0;
        };
        void specificInfo() {
            cout << "no Info: a base-class object" << endl;
        };

    private:
        int inStockQuantity;    
};

class MusicCDItem: public Item {
    public:
        string singer_name;
        void specificInfo() {
            cout << "singer name = " << singer_name << " : a derived-class object" << endl;
        };
};


void printSpecificInfo(Item *P) {
    P->specificInfo();
};

int main(void){
    Item *A;
    A = new Item();
    MusicCDItem B;

    A->specificInfo();
    B.specificInfo();

    return 0;
}