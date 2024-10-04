# Point

## Description

You have to represent a point in 2D space. Write a class with the name `Point`. The class needs two fields (instance variables) with names `x` and `y` of type `int`.

## Point Class

The `Point` class represents a point in 2D space with `x` and `y` coordinates. It includes methods to get and set these coordinates, as well as calculate the distance to another point.

### Fields

- `x` (int): The x-coordinate of the point.
- `y` (int): The y-coordinate of the point.

### Constructors

#### No-Arg Constructor
- Initializes the `Point` object with default values.

#### Parameterized Constructor
- **Parameters:** `int x`, `int y`
- Initializes the `Point` object with the given x and y coordinates.

### Methods

#### getX
- **Parameters:** None
- **Returns:** The value of the `x` field.

#### getY
- **Parameters:** None
- **Returns:** The value of the `y` field.

#### setX
- **Parameters:** `int x`
- **Action:** Sets the value of the `x` field.

#### setY
- **Parameters:** `int y`
- **Action:** Sets the value of the `y` field.

#### distance (no parameters)
- **Parameters:** None
- **Returns:** The distance between this `Point` and point (0, 0) as a double.

#### distance (with Point parameter)
- **Parameters:** `Point point`
- **Returns:** The distance between this `Point` and the specified `Point` as a double.

#### distance (with two int parameters)
- **Parameters:** `int x`, `int y`
- **Returns:** The distance between this `Point` and point (x, y) as a double.

### Distance Calculation Formula

To find the distance between points A(xA, yA) and B(xB, yB), use the formula:

\[ d(A, B) = \sqrt{(xB - xA)^2 + (yB - yA)^2} \]

Where \(\sqrt{}\) represents square root.
