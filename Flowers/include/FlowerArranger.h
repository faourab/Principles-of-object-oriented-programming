#pragma once
#ifndef FLOWERARRANGER_H
#define FLOWERARRANGER_H
#include <iostream>
#include <vector>
using std::string;
using std::vector;
using namespace std;
#include "FlowerBouquet.h"
#include "Person.h"

class FlowerArranger :public Person
{
public:
    void arrangeFlowers(FlowerBouquet* fb);
    FlowerArranger(string name);
    string getName()override;
    virtual ~FlowerArranger();
};
#endif // FLOWERARRANGER_H