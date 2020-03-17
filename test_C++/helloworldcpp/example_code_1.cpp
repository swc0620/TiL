#include <iostream>
#include <string>
using namespace std;

class Item {
    public:
        string title;
        double price;
        double SalePrice() {
            return price * 0.9;
        }
        bool isAvailable() {
            return inStockQuantity > 0;
        }
    private:
        int inStockQuantity;
};

int main(void) {
    Item a;
    a.title = "comp";
    a.price = 2000;
    cout << a.title << endl;
    cout << a.SalePrice() << endl;
    return 0;
}