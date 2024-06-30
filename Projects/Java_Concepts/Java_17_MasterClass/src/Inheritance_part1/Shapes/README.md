# Cylinder

1. Write a class with the name `Circle`. The class needs one field (instance variable) with the name `radius` of type `double`.

    The class needs to have one constructor with a parameter `radius` of type `double` and it needs to initialize the field.

    In case the `radius` parameter is less than 0, it needs to set the `radius` field value to 0.

    Write the following methods (instance methods):

    - Method named `getRadius` without any parameters; it needs to return the value of the `radius` field.
    
    - Method named `getArea` without any parameters; it needs to return the calculated area (`radius * radius * PI`). For `PI` use `Math.PI` constant.

2. Write a class with the name `Cylinder` that extends the `Circle` class. The class needs one field (instance variable) with the name `height` of type `double`.

    The class needs to have one constructor with two parameters `radius` and `height` both of type `double`. It needs to call the parent constructor and initialize the `height` field.

    In case the `height` parameter is less than 0, it needs to set the `height` field value to 0.

    Write the following methods (instance methods):

    - Method named `getHeight` without any parameters; it needs to return the value of the `height` field.
    
    - Method named `getVolume` without any parameters; it needs to return the calculated volume. To calculate volume, multiply the area with `height`.
