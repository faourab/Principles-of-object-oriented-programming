#include "FlowerBouquet.h"

FlowerBouquet::FlowerBouquet(vector<string> bouquet): bouquet(bouquet), isArranged(false){}

void FlowerBouquet::arrange()
{
    this->isArranged = true;
}

vector<string> FlowerBouquet::getBouquet()
{
    return this->bouquet;
}

bool FlowerBouquet::getIsArranged()
{
    return this->isArranged;
}
