# Shared Digit

This project provides a method named `hasSharedDigit` which checks if two given integers share at least one common digit.

## Method Definition

### `hasSharedDigit`

The `hasSharedDigit` method takes two integers as parameters and returns a boolean indicating whether there is a common digit between the two numbers.

### Parameters

- `number1` (int): The first integer, which must be within the range of 10 (inclusive) to 99 (inclusive).
- `number2` (int): The second integer, which must be within the range of 10 (inclusive) to 99 (inclusive).

### Returns

- `boolean`: 
  - Returns `true` if there is a digit that appears in both numbers.
  - Returns `false` if there is no common digit or if either number is out of the specified range.

### Example Input/Output

- `hasSharedDigit(12, 23);` → should return `true` since the digit 2 appears in both numbers.
- `hasSharedDigit(9, 99);` → should return `false` since 9 is not within the range of 10-99.
- `hasSharedDigit(15, 55);` → should return `true` since the digit 5 appears in both numbers.

### Notes

- The method `hasSharedDigit` should be defined as `public static` as per the course guidelines.
- Do not include a `main` method in the solution code.
