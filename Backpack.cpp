#include "Backpack.h"
#include <iostream>
using namespace std;

Backpack::Backpack() {
    // First 
    StoreInventory storeinventory = StoreInventory();
    this->storeInventory = storeinventory.item_list;

    // Second
    this->zones = new Item*[5];
    for(int i = 0; i < 2; i++){
        zones[i] = new Item[2];
    }
    
    // Third
    meals = NULL;
    meal_length = 0;
    items = NULL;
    item_length = 0;    
}

void Backpack::assignMeals(CustomerRequirement customerRequirement) {
    int days_on_camp = customerRequirement.getDaysOnCamp() + 1;
    int nights_on_camp = days_on_camp - 1;

    meal_length = days_on_camp * 2 + nights_on_camp * 2;
    
    Meal meal_array[meal_length];
    meals = meal_array;

    for(int i = 0; i < days_on_camp; i++){
        Meal mymeal = Meal(LUNCH, customerRequirement.getPreferredMealWeight());
        meals[i] = mymeal;
    }
    for(int i = days_on_camp; i < days_on_camp * 2; i++){
        Meal mymeal = Meal(SNACK, customerRequirement.getPreferredMealWeight());
        meals[i] = mymeal;
    }
    for(int i = days_on_camp * 2; i < days_on_camp * 2 + nights_on_camp; i++){
        Meal mymeal = Meal(BREAKFAST, customerRequirement.getPreferredMealWeight());
        meals[i] = mymeal;
    }
    for(int i = days_on_camp * 2 + nights_on_camp; i < days_on_camp * 2 + nights_on_camp * 2; i++){
        Meal mymeal = Meal(DINNER, customerRequirement.getPreferredMealWeight());
        meals[i] = mymeal;
    }
}

void Backpack::assignItem(CustomerRequirement customerRequirement) {
    int days_on_camp = customerRequirement.getDaysOnCamp() + 1;

    item_length = 4;
    if(days_on_camp > 1){
        if(customerRequirement.getPreferredMealWeight() == HIGH){
            item_length += 3;
        } else{
            item_length += 2;
        }
    }

    Item item_array[item_length];
    items = item_array;

    if(item_length == 4){
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == CLOTHING && this->storeInventory[i].getWeight() == customerRequirement.getPreferredItemWeight()){
                items[0] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == FISHING_ROD && this->storeInventory[i].getWeight() == customerRequirement.getPreferredItemWeight()){
                items[1] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == LURE && this->storeInventory[i].getWeight() == customerRequirement.getPreferredItemWeight()){
                items[2] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == WATER && this->storeInventory[i].getWeight() == HIGH){
                items[3] = this->storeInventory[i];
                break;
            }
        }
    } else if(item_length == 6){
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == CLOTHING && this->storeInventory[i].getWeight() == customerRequirement.getPreferredItemWeight()){
                items[0] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == FISHING_ROD && this->storeInventory[i].getWeight() == customerRequirement.getPreferredItemWeight()){
                items[1] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == LURE && this->storeInventory[i].getWeight() == customerRequirement.getPreferredItemWeight()){
                items[2] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == WATER && this->storeInventory[i].getWeight() == HIGH){
                items[3] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == SLEEPING_BAG && this->storeInventory[i].getWeight() == MEDIUM){
                items[4] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == TENT && this->storeInventory[i].getWeight() == customerRequirement.getPreferredItemWeight()){
                items[5] = this->storeInventory[i];
                break;
            }
        }
    } else{
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == CLOTHING && this->storeInventory[i].getWeight() == customerRequirement.getPreferredItemWeight()){
                items[0] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == FISHING_ROD && this->storeInventory[i].getWeight() == customerRequirement.getPreferredItemWeight()){
                items[1] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == LURE && this->storeInventory[i].getWeight() == customerRequirement.getPreferredItemWeight()){
                items[2] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == WATER && this->storeInventory[i].getWeight() == HIGH){
                items[3] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == SLEEPING_BAG && this->storeInventory[i].getWeight() == MEDIUM){
                items[4] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == TENT && this->storeInventory[i].getWeight() == customerRequirement.getPreferredItemWeight()){
                items[5] = this->storeInventory[i];
                break;
            }
        }
        for(int i = 0; i < 42; i++){
            if(this->storeInventory[i].getItemType() == COOKING && this->storeInventory[i].getWeight() == MEDIUM){
                items[6] = this->storeInventory[i];
                break;
            }
        }
    }


}

void Backpack::packBackpack() {
    for(int i = 0; i < item_length; i++){
        if(items[i].getItemType() == LURE){
            zones[0][0] = items[i];
            break;
        }
    }
    for(int i = 0; i < item_length; i++){
        if(items[i].getItemType() == FISHING_ROD){
            zones[1][0] = items[i];
            break;
        }
    }
    for(int i = 0; i < item_length; i++){
        if(items[i].getItemType() == CLOTHING){
            zones[2][0] = items[i];
            break;
        }
    }
    int index1 = 0;
    for(int i = 0; i < item_length; i++){
        if(items[i].getItemType() == COOKING){
            zones[3][0] = items[i];
            index1 = 1;
            break;
        }
    }
    for(int i = 0; i < item_length; i++){
        if(index1 == 0 && items[i].getItemType() == WATER){
            zones[3][0] = Item(SLEEPING_BAG, LOW);
            zones[3][1] = items[i];
            break;
        } else if(index1 == 1 && items[i].getItemType() == WATER){
            zones[3][1] = items[i];
            break;
        }
    }
    int index2 = 0;
    for(int i = 0; i < item_length; i++){
        if(items[i].getItemType() == SLEEPING_BAG){
            zones[4][0] = items[i];
            index2 = 1;
            break;
        }
    }
    for(int i = 0; i < item_length; i++){
        if(index2 == 0 && items[i].getItemType() == TENT){
            zones[3][0] = Item(SLEEPING_BAG, LOW);
            zones[4][1] = items[i];
            break;
        } else if(index2 == 1 && items[i].getItemType() == TENT){
            zones[4][1] = items[i];
            break;
        }
    }
}

void Backpack::addItem(Item item) {
    Item item_array[item_length + 1];
    item_array[item_length] = item;
    this->items = item_array;

    item_length++;
}

void Backpack::removeItem(int i) {
    Item item_array[item_length - 1];
    for(int j = 0; j < item_length - 1; j++){
        if(j < i){
            item_array[j] = items[j];
        } else{
            item_array[j] = items[j+1];
        }
    }
    this->items = item_array;

    item_length--;
}

void Backpack::removeItem(Item item) {
    if(item_length == 0){

    } else{
        int j = 0;
        while(j < item_length){
            if(items[j].getItemType() == item.getItemType() && items[j].getWeight() == item.getWeight()){
                break;
            }
            j++;
        }
        removeItem(j);
    }
}

void Backpack::print() {
    cout << "Zone 0:" << endl;
    cout << "\t" << "Item{Item Type: LURE, Weight: ";
    if(zones[0][0].getWeight() == LOW){
        cout << "LOW";
    } else if(zones[0][0].getWeight() == MEDIUM){
        cout << "MEDIUM";
    } else{
        cout << "HIGH";
    }
    cout << "}" << endl;

    cout << "Zone 1:" << endl;
    cout << "\t" << "Item{Item Type: FISHING_ROD, Weight: ";
    if(zones[1][0].getWeight() == LOW){
        cout << "LOW";
    } else if(zones[1][0].getWeight() == MEDIUM){
        cout << "MEDIUM";
    } else{
        cout << "HIGH";
    }
    cout << "}" << endl;

    cout << "Zone 2:" << endl;
    cout << "\t" << "Item{Item Type: CLOTHING, Weight: ";
    if(zones[2][0].getWeight() == LOW){
        cout << "LOW";
    } else if(zones[2][0].getWeight() == MEDIUM){
        cout << "MEDIUM";
    } else{
        cout << "HIGH";
    }
    cout << "}" << endl;

    cout << "Zone 3:" << endl;
    cout << "\t";
    if(zones[3][0].getItemType() == SLEEPING_BAG){
        cout << "Item{Item Type: WATER, Weight: HIGH}" << endl;
    } else{
        cout << "Item{Item Type: COOKING, Weight: ";
        if(zones[3][0].getWeight() == LOW){
            cout << "LOW";
        } else if(zones[3][0].getWeight() == MEDIUM){
            cout << "MEDIUM";
        } else{
            cout << "HIGH";
        }
        cout<< "}" << endl;
        cout << "Item{Item Type: WATER, Weight: HIGH}" << endl;
    }

    cout << "Zone 3:" << endl;
    cout << "\t";
    if(zones[4][0].getWeight() == LOW){
        cout << endl;
    } else{
        cout << "Item{Item Type: SLEEPING_BAG, Weight: MEDIUM}" << endl;

        cout << "Item{Item Type: TENT, Weight: ";
        if(zones[4][1].getWeight() == LOW){
            cout << "LOW";
        } else if(zones[4][1].getWeight() == MEDIUM){
            cout << "MEDIUM";
        } else{
            cout << "HIGH";
        }
        cout<< "}" << endl;
    }

}

Meal* Backpack::getMeals() {
    return meals;
}

void Backpack::setMeals(Meal* m) {
    meals = m;
}

int Backpack::getMealLength() {
    return meal_length;
}

Item* Backpack::getItems() {
    return items;
}

void Backpack::setItems(Item* it) {
    items = it;
}

int Backpack::getItemLength() {
    return item_length;
}

Item** Backpack::getZones() {
    return zones;
}

void Backpack::setZones(Item** z) {
    zones = z;
}

Item* Backpack::getStoreInventory() {
    return storeInventory;
}

void Backpack::setStoreInventory(Item* s) {
    storeInventory = s;
}
