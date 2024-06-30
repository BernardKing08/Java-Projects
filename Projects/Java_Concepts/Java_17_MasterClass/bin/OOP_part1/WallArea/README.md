# Wall Area

## Description

Write a class with the name `Wall`. The class needs two fields (instance variables) with names `width` and `height` of type `double`.

## Wall Class

The `Wall` class represents a wall with a width and a height. It includes methods to get and set these dimensions, as well as calculate the area of the wall.

### Fields

- `width` (double): The width of the wall.
- `height` (double): The height of the wall.

### Constructors

#### No-Args Constructor
- Initializes the `Wall` object with default values.

#### Parameterized Constructor
- **Parameters:** `double width`, `double height`
- Initializes the `Wall` object with the given width and height.
  - If the width parameter is less than 0, sets the `width` field value to 0.
  - If the height parameter is less than 0, sets the `height` field value to 0.

### Methods

#### getWidth
- **Parameters:** None
- **Returns:** The value of the `width` field.

#### getHeight
- **Parameters:** None
- **Returns:** The value of the `height` field.

#### setWidth
- **Parameters:** `double width`
- **Action:** Sets the value of the `width` field. If the parameter is less than 0, sets the `width` field value to 0.

#### setHeight
- **Parameters:** `double height`
- **Action:** Sets the value of the `height` field. If the parameter is less than 0, sets the `height` field value to 0.

#### getArea
- **Parameters:** None
- **Returns:** The area of the wall.
