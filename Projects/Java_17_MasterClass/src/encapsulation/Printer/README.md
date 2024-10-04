# Encapsulation

In this exercise, you will create one class and name it `Printer`. This class will have two member variables of type `int`, `tonerLevel` and `pagesPrinted`, and one of type `boolean` called `duplex`. All three fields will have `private` access. The constructor will accept two of these variables, `tonerLevel` and `duplex`, as parameters following these rules:

- `tonerLevel` must be greater than -1 but less than or equal to 100. If it does not meet these conditions, then it should be initialized to -1.
- `duplex` should be initialized to the value of the parameter.
- `pagesPrinted` should be initialized to 0.

Three other methods need to be defined in this way:

- `addToner` will accept one parameter, `tonerAmount` of type `int`. First off, `tonerAmount` should be greater than 0 and less than or equal to 100. If this condition is met, a second test must be included to test whether `tonerLevel` plus `tonerAmount` is greater than 100. If so, the method should return -1. If not, then `tonerLevel` should have the incoming `tonerAmount` added to it and the new `tonerLevel` should then be returned by the method. Also, if the initial condition test fails, then the method should return -1.

- `printPages` will accept one parameter, `pages` of type `int`. A variable called `pagesToPrint` should be created and initialized to the value of the incoming parameter. A conditional check should be performed on whether the `Printer` class field, `duplex`, is either `true` or `false`. If `true`, then a calculation must be performed to determine the number of pages needed to print the job double-sided. The `pagesToPrint` value is then added to the class field `pagesPrinted`, but the value of `pagesToPrint` should be returned by the method.

- `getPagesPrinted` has no parameters and merely returns the value of the member variable `pagesPrinted`.
