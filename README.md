# VehicleShowroom
This is a command line system using Java for a Vehicle Showroom.
There are 3 types of vehicles in the showroom: Normal vehicle, Sports vehicle and Heavy vehicle.
A vehicle has 4 properties which are Model Number, Engine Type, Engine Power and Tire Size.
The engine of a normal vehicle can be of 3 types: Oil, Gas and Diesel whereas the engine of 
a Sports vehicle can be of only Oil type and for a Heavy vehicle it can be only of Diesel type.
A sports vehcile has a unique property called Turbo and a Heavy vehicle has the property 
Weight.
The expected visitor count of the showroom is 30 but whenever a new Sports vehcile is introduces, it increases by 20.

# Design Patterns used
## 1. Factory pattern
> VehicleFactory creates any type of vehicles. 
## 2. Observer pattern
> VisitorObserver observes the list of vehicles present in the showroom and updates the current visitor count depending on the number of Sports vehicles in the showroom.
## 3. Singleton pattern
> Singleton pattern is used for creating single instances of VehicleFactory, VehicleSubject and VehicleObserver. 

# The functionalities that the system has are - 

> * Any type of vehicle can be added in the showroom.
> * Any of the vehicles can be removed from the showroom.
> * A list of the vehicles that are currently in the showroom can be shown.
> * A list of vehicles with the current expected visitor count can be shown.

# Output
```
1. For adding a vehicle, enter 1
2. For removing a vehicle, enter 2
3. To see the Vehicle List and expected number of visitors, enter 3
4. To exit, enter 4

1

1. For adding a Normal vehicle, enter 1
2. For adding a Sports vehicle, enter 2
3. For adding a Heavy vehicle, enter 3


1

1. If the engine type is Oil, enter 1
2. If the engine type is Gas, enter 2
3. If the engine type is Diesel, enter 3


2

Enter the model number of the vehicle

Toyota Corolla

Enter the engine power of the vehicle in hp

139

Enter the tire size of the vehicle in inches

17

Vehicle is added



----------------------------------------------------------
Vehicle List:
1. Vehicle Type: Normal
   Model Number: Toyota Corolla
   Engine Type: Gas
   EnginePower: 139 hp
   Tire Size: 17 inch

Current expected visitor count:  30

----------------------------------------------------------

1. For adding a vehicle, enter 1
2. For removing a vehicle, enter 2
3. To see the Vehicle List and expected number of visitors, enter 3
4. To exit, enter 4

2

Enter the serial number of the vehicle in the list to remove

1

Vehicle is removed



----------------------------------------------------------
Vehicle List:
There are no vehicles in the showroom
----------------------------------------------------------

1. For adding a vehicle, enter 1
2. For removing a vehicle, enter 2
3. To see the Vehicle List and expected number of visitors, enter 3
4. To exit, enter 4

1

1. For adding a Normal vehicle, enter 1
2. For adding a Sports vehicle, enter 2
3. For adding a Heavy vehicle, enter 3


2

1. If the turbo type is Single, enter 1
2. If the turbo type is Twin, enter 2
3. If the turbo type is Twin Scroll, enter 3
4. If the turbo type is Variable Geometry, enter 4
5. If the turbo type is Variable Twin Scroll, enter 5
6. If the turbo type is Electric, enter 6


2

Enter the model number of the vehicle

BMW M3 GTR

Enter the engine power of the vehicle in hp

500

Enter the tire size of the vehicle in inches

22

Vehicle is added



----------------------------------------------------------
Vehicle List:
1. Vehicle Type: Sports
   Model Number: BMW M3 GTR
   Engine Type: Oil
   EnginePower: 500 hp
   Tire Size: 22 inch
   Turbo: Twin

Current expected visitor count:  50

----------------------------------------------------------

1. For adding a vehicle, enter 1
2. For removing a vehicle, enter 2
3. To see the Vehicle List and expected number of visitors, enter 3
4. To exit, enter 4

4
Goodbye
```
