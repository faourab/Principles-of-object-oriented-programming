#include <iostream>
#include "Person.h"
#include "Florist.h"
#include "FlowerBouquet.h"

using namespace std;

Person::Person(string name) : name(name){}

string Person::getName() {
    return this->name;
}

Person::~Person(){}

void Person::orderFlowers(Florist* f, Person* p, vector<string> v)
{
    string response = this->name + " orders flowers to " + p->name + " from " + f->getName() + ": ";
    for (size_t i = 0; i < v.size(); i++)
    {
        if (i != v.size() - 1)
            response += v[i] + ", ";
        else response += v[i];
    }
    response += ".";
    cout << response << endl;
    response = f->getName() + " forwards request to " + f->getWholesaler()->getName() + ".";
    f->acceptOrder(p, v);
}

void Person::acceptFlowers(FlowerBouquet* fb)
{
    string response = this->name += " accepts the flowers ";
    vector<string> v = fb->getBouquet();
    for (size_t i = 0; i < v.size(); i++)
    {
        if (i != v.size() - 1)
            response += v[i] + ", ";
        else response += v[i] + ".";
    }
    cout << response << endl;
    delete fb;
    fb = nullptr;
}