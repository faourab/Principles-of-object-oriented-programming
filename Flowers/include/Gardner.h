#pragma once
#ifndef GARDNER_H
#define GARDNER_H
#include <iostream>
#include <vector>
using std::string;
using std::vector;
using namespace std;
#include "FlowerBouquet.h"
#include "Person.h"

class Gardner :public Person
{
public:
	FlowerBouquet* prepareOrder(vector<string> flowers);
	Gardner(string name);
	string getName()override;
	virtual ~Gardner();
};
#endif // GARDNER_H