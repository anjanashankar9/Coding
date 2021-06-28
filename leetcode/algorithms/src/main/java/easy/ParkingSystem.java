package easy;

/**
 * @Author Anjana Shankar
 * @Created 2021-06-16
 */
public class ParkingSystem {
    int MAX_SMALL;
    int MAX_MEDIUM;
    int MAX_BIG;

    int small;
    int medium;
    int big;

    public ParkingSystem(int big, int medium, int small) {
        this.MAX_SMALL = small;
        this.MAX_MEDIUM = medium;
        this. MAX_BIG = big;

        small = medium = big = 0;
    }

    public boolean addCar(int carType) {
        switch(carType) {
            case 1: //BIG
                if (big == MAX_BIG) {
                    return false;
                }
                big++;
                return true;

            case 2: //MEDIUM
                if (medium == MAX_MEDIUM) {
                    return false;
                }
                medium++;
                return true;

            case 3: //SMALL
                if (small == MAX_SMALL) {
                    return false;
                }
                small++;
                return true;
        }
        return false;
    }
}

/*
Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, and small, with a fixed number of slots for each size.

Implement the ParkingSystem class:

ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class. The number of slots for each parking space are given as part of the constructor.
bool addCar(int carType) Checks whether there is a parking space of carType for the car that wants to get into the parking lot. carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively. A car can only park in a parking space of its carType. If there is no space available, return false, else park the car in that size space and return true.


Example 1:

Input
["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
[[1, 1, 0], [1], [2], [3], [1]]
Output
[null, true, true, false, false]

Explanation
ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
parkingSystem.addCar(3); // return false because there is no available slot for a small car
parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.


Constraints:

0 <= big, medium, small <= 1000
carType is 1, 2, or 3
At most 1000 calls will be made to addCar

 */
//https://leetcode.com/problems/design-parking-system/
