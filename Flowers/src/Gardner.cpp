#include <iostream>
#include "Gardner.h"
#include "FlowerBouquet.h"

using namespace std;
FlowerBouquet* Gardner::prepareOrder(vector<string> flowers)
{
    string response = this->getName() + " prepares flowers.";
    cout << response << endl;
    return new FlowerBouquet(flowers);
}

Gardner::Gardner(string n) :Person(n) {}

string Gardner::getName()
{
    return "Gardner " + Person::getName();
}

Gardner::~Gardner(){}
