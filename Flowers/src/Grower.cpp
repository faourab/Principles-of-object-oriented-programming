#include <iostream>
#include "Grower.h"
#include "Gardner.h"
#include "FlowerBouquet.h"

FlowerBouquet* Grower::prepareOrder(vector<string> flowers)
{
    string response = this->getName() + " forwards the request to " + gardner->getName() + ".";
    cout << response << endl;
    FlowerBouquet* fb = this->gardner->prepareOrder(flowers);
    response = gardner->getName() + " returns flowers to " + this->getName() + ".";
    cout << response << endl;
    return fb;
}

Gardner* Grower::getGardner()
{
    return this->gardner;
}

Grower::Grower(string n, Gardner* g) :Person(n), gardner(g){}

string Grower::getName() {
    return "Grower " + Person::getName();
}

Grower::~Grower(){}
