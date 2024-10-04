# Composition

This is an exercise in Class Composition. To complete the exercise, you must create five classes with associated member variables and methods.

The five classes should be created as follows:

1. Create a class and name it `Lamp`. Inside this class, three member variables should be declared: `style` of type `String`, `battery` of type `boolean`, and `globRating` of type `int`. All variables should be marked `private`. A constructor needs to be created which accepts the three member variables as parameters. In addition, four methods should also be created: 
   - `turnOn()` has no return type and should print a message that the lamp is being turned on.
   - `getStyle()` returns the lamp style.
   - `isBattery()` returns the value of `battery`.
   - `getGlobRating()` returns the `globRating` of the lamp.

2. Create a class and name it `Bed`. Five `private` member variables should be declared: `style` of type `String`, and `pillows`, `height`, `sheets`, `quilt` of type `int`. A constructor should be coded which accepts these five member variables as parameters. Also, six methods should be defined:
   - `make()` has no return type and prints a message to the effect that the bed is being made.
   - `getStyle()` returns the value of `style`.
   - `getPillows()` returns the number of pillows.
   - `getHeight()` returns the height of the bed.
   - `getSheets()` returns the number of sheets on the bed.
   - `getQuilt()` returns the value of `quilt`.

3. Create a class with the name `Ceiling`. There are two member variables for this one, `height` and `paintedColor`, both of type `int`. There should also be a constructor which accepts both member variables as parameters. There are also two additional methods which should be defined:
   - `getHeight()` returns the value of `height`.
   - `getPaintedColor()` returns the value of `paintedColor`.

4. Create a class with the name `Wall`. It contains one member variable, `direction`, of type `String`. A constructor for `Wall` should accept one parameter for the member variable `direction`. A getter should also be defined for the `direction` field called `getDirection()`.

5. Create a class with the name `Bedroom`. This class contains eight member variables:
   - `name` of type `String`
   - `wall1`, `wall2`, `wall3`, `wall4` of type `Wall`
   - `ceiling` of type `Ceiling`
   - `bed` of type `Bed`
   - `lamp` of type `Lamp`

   The class constructor should accept all eight of the member variables as parameters, and there should also be two additional methods:
   - `getLamp()` returns an object of type `Lamp`.
   - `makeBed()` prints a message that the bed is being made and also calls the `make()` method in the `Bed` class.
