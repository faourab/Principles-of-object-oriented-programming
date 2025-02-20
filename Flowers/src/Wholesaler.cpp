#include <iostream>
#include "Wholesaler.h"
#include "Grower.h"
#include "FlowerBouquet.h"

using namespace std;

Wholesaler::Wholesaler(string n, Grower* g) :Person(n) , grower(g){}

FlowerBouquet* Wholesaler::acceptOrder(vector<string> flowers)
{
    string response = this->getName() + " forwards the request to " + " " + this->grower->getName();
    cout << response << endl;
    FlowerBouquet* fb = this->getgrower()->prepareOrder(flowers);
    response = this->grower->getName() + " returns flowers to " + this->getName() + ".";
    cout << response << endl;
    return fb;
}

Grower* Wholesaler::getgrower()
{
    return this->grower;
}

string Wholesaler::getName() {
    return "wholesaler "+Person::getName();
}

Wholesaler::~Wholesaler(){}
