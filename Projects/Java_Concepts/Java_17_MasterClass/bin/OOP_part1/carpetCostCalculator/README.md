# Carpet Cost Calculator

## Description

The Carpet Company has asked you to write an application that calculates the price of carpeting for rectangular rooms. To calculate the price, you multiply the area of the floor (width times length) by the price per square meter of carpet. For example, the area of a floor that is 12 meters long and 10 meters wide is 120 square meters. To cover the floor with a carpet that costs $8 per square meter would cost $960.

## Floor Class

The `Floor` class represents a rectangular floor with a width and length.

### Fields

- `width` (double): The width of the floor.
- `length` (double): The length of the floor.

### Constructor

#### Parameterized Constructor
- **Parameters:** `double width`, `double length`
- Initializes the `Floor` object with the given width and length.
  - If the width parameter is less than 0, sets the `width` field value to 0.
  - If the length parameter is less than 0, sets the `length` field value to 0.

### Methods

#### getArea
- **Parameters:** None
- **Returns:** The calculated area (`width * length`).

# Carpet Cost Calculator - Carpet and Calculator Classes

## Carpet Class

The `Carpet` class represents the cost per square meter of a carpet.

### Fields

- `cost` (double): The cost per square meter of the carpet.

### Constructor

#### Parameterized Constructor
- **Parameters:** `double cost`
- Initializes the `Carpet` object with the given cost.
  - If the cost parameter is less than 0, sets the `cost` field value to 0.

### Methods

#### getCost
- **Parameters:** None
- **Returns:** The value of the `cost` field.



# Calculator Class

The `Calculator` class calculates the total cost to cover a floor with a carpet.

### Fields

- `floor` (Floor): The floor object representing the dimensions of the floor.
- `carpet` (Carpet): The carpet object representing the cost per square meter.

### Constructor

#### Parameterized Constructor
- **Parameters:** `Floor floor`, `Carpet carpet`
- Initializes the `Calculator` object with the given floor and carpet.

### Methods

#### getTotalCost
- **Parameters:** None
- **Returns:** The calculated total cost to cover the floor with a carpet.
