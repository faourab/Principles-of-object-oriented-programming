#include <iostream>
#include "Florist.h"
#include "Wholesaler.h"
#include "FlowerArranger.h"
#include "DeliveryPerson.h"
#include "FlowerBouquet.h"

using namespace std;
void Florist::acceptOrder(Person* p, vector<string> flowers)
{
    string response = getName() + " forwards request to " + " " +getWholesaler()->getName() + ".";
    std::cout << response << std::endl;
    FlowerBouquet* b = this->wholesaler->acceptOrder(flowers);
    response = wholesaler->getName() + " returns flowers to " + this->getName();
    std::cout << response << std::endl;
    response = this->getName() + " request flowers arrangement from " + flowerArranger->getName();
    std::cout << response << std::endl;
    this->flowerArranger->arrangeFlowers(b);
    cout << this->getName() + " returns arranged flowers to " + this->getName() << endl;
    response = this->getName() + " forwards flowers to " + deliveryPerson->getName();
    cout << response << endl;
    this->deliveryPerson->deliver(p, b);
}

string Florist::getName() {

    return "Florist " + Person::getName();
}

Florist::~Florist(){}

Wholesaler* Florist::getWholesaler()
{
    return this->wholesaler;
}

FlowerArranger* Florist::getFlowerArranger()
{
    return this->flowerArranger;
}

DeliveryPerson* Florist::getDeliveryPerson()
{
    return this->deliveryPerson;
}

Florist::Florist(string n, Wholesaler* w, FlowerArranger* f, DeliveryPerson* d) :Person(n) , wholesaler(w), flowerArranger(f), deliveryPerson(d){}
