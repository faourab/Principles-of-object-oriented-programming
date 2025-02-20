#pragma once
#ifndef FLOWERBOUQUET_H
#define FLOWERBOUQUET_H
#include <iostream>
#include <vector>
using std::string;
using std::vector;
using namespace std;

class FlowerBouquet
{
private:
	vector<string> bouquet;
	bool isArranged;
public:
	FlowerBouquet(vector<string> bouquet);
	void arrange();
	vector<string> getBouquet();
	bool getIsArranged();
};
#endif // FLOWERBOUQUET_H