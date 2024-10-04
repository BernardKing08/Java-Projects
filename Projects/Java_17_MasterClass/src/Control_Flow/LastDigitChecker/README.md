# Same Last Digit

This project provides two methods: `hasSameLastDigit` and `isValid`.

## Method Definition

### `hasSameLastDigit`

The `hasSameLastDigit` method takes three integers as parameters and returns a boolean indicating whether at least two of the numbers share the same rightmost digit.

### Parameters

- `number1` (int): The first integer, which must be within the range of 10 (inclusive) to 1000 (inclusive).
- `number2` (int): The second integer, which must be within the range of 10 (inclusive) to 1000 (inclusive).
- `number3` (int): The third integer, which must be within the range of 10 (inclusive) to 1000 (inclusive).

### Returns

- `boolean`: 
  - Returns `true` if at least two of the numbers share the same rightmost digit.
  - Returns `false` if no two numbers share the same rightmost digit or if any number is out of the specified range.

### Example Input/Output

- `hasSameLastDigit(41, 22, 71);` → should return `true` since 1 is the rightmost digit in numbers 41 and 71.
- `hasSameLastDigit(23, 32, 42);` → should return `true` since 2 is the rightmost digit in numbers 32 and 42.
- `hasSameLastDigit(9, 99, 999);` → should return `false` since 9 is not within the range of 10-1000.

## Method Definition

### `isValid`

The `isValid` method takes an integer as a parameter and returns a boolean indicating whether the number is within the range of 10 (inclusive) to 1000 (inclusive).

### Parameters

- `number` (int): The integer to check for validity.

### Returns

- `boolean`: 
  - Returns `true` if the number is within the range of 10-1000 (inclusive).
  - Returns `false` if the number is outside the specified range.

### Example Input/Output

- `isValid(10);` → should return `true` since 10 is within the range of 10-1000.
- `isValid(468);` → should return `true` since 468 is within the range of 10-1000.
- `isValid(1051);` → should return `false` since 1051 is not within the range of 10-1000.

### Notes

- All methods (`hasSameLastDigit` and `isValid`) need to be defined as `public static` as per the course guidelines.
- Do not include a `main` method in the solution code.
