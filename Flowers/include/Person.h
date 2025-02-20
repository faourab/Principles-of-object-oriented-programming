//#pragma once
//#ifndef PERSON_H
//#define PERSON_H
//#include <iostream>
//#include <vector>
//using std::string;
//using std::vector;
//using namespace std;
//class Florist;
//#include "FlowerBouquet.h"
#pragma once
#ifndef PERSON_H
#define PERSON_H

#include <string>
#include <vector>

using std::string;
using std::vector;

class Florist;
class FlowerBouquet;

class Person
{
private:
    string name;

public:
    Person(string name);
    void orderFlowers(Florist* f, Person* p, vector<string> v);
    void acceptFlowers(FlowerBouquet* fb);
    virtual string getName();
    virtual ~Person();

};
#endif // PERSON_H