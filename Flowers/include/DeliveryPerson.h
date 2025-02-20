//#pragma once
//#ifndef DELEVERYPERSON_H   
//#define DELEVERYPERSON_H
//#include <iostream>
//#include <vector>
//using std::string;
//using std::vector;
//using namespace std;
//#include "Person.h"
//#include "FlowerBouquet.h"

#pragma once
#ifndef DELIVERY_PERSON_H
#define DELIVERY_PERSON_H

#include <string>
#include "Person.h"
#include "FlowerBouquet.h"

using std::string;

class DeliveryPerson :public Person
{
public:
    void deliver(Person* p, FlowerBouquet* fb);
    DeliveryPerson(string name);
    string getName()override;
    virtual ~DeliveryPerson();
};
#endif // DELEVERYPERSON_H