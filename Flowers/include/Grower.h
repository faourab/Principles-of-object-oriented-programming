#pragma once
#ifndef GROWER_H
#define GROWER_H
#include <iostream>
#include <vector>
using std::string;
using std::vector;
#include "Gardner.h"
#include "FlowerBouquet.h"
#include "Person.h"
using namespace std;

class Grower :public Person
{
private:
    Gardner* gardner;
public:
    FlowerBouquet* prepareOrder(vector<string> flowers);
    Gardner* getGardner();
    Grower(string name, Gardner* g);
    string getName() override;
    virtual ~Grower();

};
#endif // GROWER_H