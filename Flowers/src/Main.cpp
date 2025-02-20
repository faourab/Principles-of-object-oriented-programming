#include <iostream>
#include "Person.h"
#include "Gardner.h"
#include "Grower.h"
#include "DeliveryPerson.h"
#include "FlowerArranger.h"
#include "Wholesaler.h"
#include "Florist.h"

using namespace std;


int main() {
    // Your code here
    Person* person1 = new Person("Chris");
    Person* person2 = new Person("Robin");
    Gardner* gardner = new Gardner("Garett");
    Grower* grower = new Grower("Gray", gardner);
    Wholesaler* wholesaler = new Wholesaler("Watson", grower);
    FlowerArranger* f = new FlowerArranger("Flora");
    DeliveryPerson* d = new DeliveryPerson("Dylan");
    Florist* florist = new Florist("Fred", wholesaler, f, d);
    person1->orderFlowers(florist, person2, { "Roses", "Violets", "Gladiolus" });
    delete person1;
    delete person2;
    delete f;
    delete gardner;
    delete grower;
    delete wholesaler;
    delete florist;
    delete d;
    return 0;
}