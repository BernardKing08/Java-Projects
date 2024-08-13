# Vehicle Polymorphism

## Description

This project demonstrates the concept of polymorphism in Java by creating four classes of vehicles. The base class is `Car`, and it has three subclasses: `Mitsubishi`, `Holden`, and `Ford`.

## Car Class

The `Car` class is the base class with the following member variables:
- `engine` of type `boolean`
- `cylinders` of type `int`
- `name` of type `String`
- `wheels` of type `int`

### Member Variables
All member variables have private access. The constructor accepts two parameters: `cylinders` and `name`. The `engine` is set to `true` and `wheels` are set to `4` by default.

### Methods
The `Car` class includes the following methods:
- `startEngine`: Accepts no parameters and returns a message indicating that the car's engine is starting.
- `accelerate`: Accepts no parameters and returns a message indicating that the car is accelerating.
- `brake`: Accepts no parameters and returns a message indicating that the car is braking.
- `getCylinders`: Returns the number of cylinders.
- `getName`: Returns the name of the car.

## Mitsubishi, Holden, and Ford Classes

These classes are subclasses of `Car`. They inherit the member variables and methods from the `Car` class. Each subclass overrides the methods `startEngine`, `accelerate`, and `brake` to provide messages that include the subclass name.

### Summary of Subclasses
- **Mitsubishi**: Inherits from `Car` and overrides `startEngine`, `accelerate`, and `brake` methods.
- **Holden**: Inherits from `Car` and overrides `startEngine`, `accelerate`, and `brake` methods.
- **Ford**: Inherits from `Car` and overrides `startEngine`, `accelerate`, and `brake` methods.

## Usage

1. Instantiate the `Car` class or any of its subclasses (`Mitsubishi`, `Holden`, `Ford`).
2. Call the `startEngine`, `accelerate`, and `brake` methods on the objects to see polymorphism in action.

## Example Input

```java
Car car = new Car(8, "Base car");
System.out.println(car.startEngine());
System.out.println(car.accelerate());
System.out.println(car.brake());
 
Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
System.out.println(mitsubishi.startEngine());
System.out.println(mitsubishi.accelerate());
System.out.println(mitsubishi.brake());
 
Ford ford = new Ford(6, "Ford Falcon");
System.out.println(ford.startEngine());
System.out.println(ford.accelerate());
System.out.println(ford.brake());
 
Holden holden = new Holden(6, "Holden Commodore");
System.out.println(holden.startEngine());
System.out.println(holden.accelerate());
System.out.println(holden.brake());
```

## Example Output
```java
Car -> startEngine()
Car -> accelerate()
Car -> brake()
Mitsubishi -> startEngine()
Mitsubishi -> accelerate()
Mitsubishi -> brake()
Ford -> startEngine()
Ford -> accelerate()
Ford -> brake()
Holden -> startEngine()
Holden -> accelerate()
Holden -> brake()
```