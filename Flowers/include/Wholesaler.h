#pragma once
#ifndef WHOLESALER_H
#define WHOLESALER_H
#include <iostream>
#include <vector>
#include <string> 
#include "Grower.h" 
#include "FlowerBouquet.h"
#include"Person.h"
using std::string;
using std::vector;
using namespace std;

class Wholesaler :public Person
{
private:
    Grower* grower;
public:
    Wholesaler(string name, Grower* g);
    FlowerBouquet* acceptOrder(vector<string> flowers);
    Grower* getgrower();
    string getName() override;
    virtual ~Wholesaler();
};
#endif // WHOLESALER_H