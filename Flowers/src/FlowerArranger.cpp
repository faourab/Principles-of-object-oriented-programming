#include <iostream>
#include "FlowerArranger.h"
#include "FlowerBouquet.h"

using namespace std;
FlowerArranger::FlowerArranger(string n) : Person(n) {}

void FlowerArranger::arrangeFlowers(FlowerBouquet* fb)
{
    cout << this->getName() + " arranges flowers." << endl;
    fb->arrange();
}

string FlowerArranger::getName() {
    return "Flower Arranger " + Person::getName();
}

FlowerArranger::~FlowerArranger(){}
