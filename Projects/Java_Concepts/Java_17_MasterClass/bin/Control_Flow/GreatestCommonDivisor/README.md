# Greatest Common Divisor

This project provides a method named `getGreatestCommonDivisor` which calculates the greatest common divisor (GCD) of two given integers.

## Method Definition

### `getGreatestCommonDivisor`

The `getGreatestCommonDivisor` method takes two integers `first` and `second` as parameters and returns the greatest common divisor of the two numbers. If either parameter is less than 10, the method returns -1 to indicate an invalid value.

### Parameters

- `first` (int): The first integer for which the GCD needs to be calculated.
- `second` (int): The second integer for which the GCD needs to be calculated.

### Returns

- `int`: 
  - Returns the greatest common divisor of the two numbers.
  - Returns -1 if either parameter is less than 10.

### Example Input/Output

- `getGreatestCommonDivisor(25, 15);` should return 5 since both can be divided by 5 without a remainder.
- `getGreatestCommonDivisor(12, 30);` should return 6 since both can be divided by 6 without a remainder.
- `getGreatestCommonDivisor(9, 18);` should return -1 since the first parameter is less than 10.
- `getGreatestCommonDivisor(81, 153);` should return 9 since both can be divided by 9 without a remainder.

### Notes

- The method `getGreatestCommonDivisor` should be defined as `public static` as per the course guidelines.
- Do not include a `main` method in the solution code.
