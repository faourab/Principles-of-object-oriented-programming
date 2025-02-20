#pragma once
#ifndef FLORIST_H
#define FLORIST_H
#include <string>
#include <vector>
using namespace std;
#include "Wholesaler.h"
#include "FlowerArranger.h"
#include "DeliveryPerson.h"
#include "Person.h"
using std::string;
using std::vector;


class Florist :public Person
{
private:
    Wholesaler* wholesaler;
    FlowerArranger* flowerArranger;
    DeliveryPerson* deliveryPerson;
public:
    void acceptOrder(Person* p, vector<string> flowers);
    Wholesaler* getWholesaler();
    FlowerArranger* getFlowerArranger();
    DeliveryPerson* getDeliveryPerson();
    Florist(string name, Wholesaler* w, FlowerArranger* f, DeliveryPerson* d);
    string getName()override;
    virtual ~Florist();
};

#endif // FLORIST_H