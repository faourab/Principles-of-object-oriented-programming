#include <iostream>
#include "DeliveryPerson.h"
#include "Person.h"
#include "FlowerBouquet.h"

using namespace std;

void DeliveryPerson::deliver(Person* p, FlowerBouquet* fb)
{
    cout << this->getName() + " delivers flowers to " + p->getName() << endl;
    p->acceptFlowers(fb);
}

string DeliveryPerson::getName() {
    return "DeliveryPerson " + Person::getName();
}

DeliveryPerson::~DeliveryPerson(){}

DeliveryPerson::DeliveryPerson(string n) :Person(n) {}

