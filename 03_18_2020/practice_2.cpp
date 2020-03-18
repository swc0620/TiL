#include <iostream>
#include <assert.h>
#include <string.h>

using namespace std;

class String {
    public:
        String(const char *s) {
            len = strlen(s);
            str = new char[len + 1];
            assert(str != 0);
            strcpy(str, s);
        }
        ~String() {
            delete [] str;
        }
    private:
        int len;
        char *str;    
};