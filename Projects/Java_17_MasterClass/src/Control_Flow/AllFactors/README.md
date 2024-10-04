# All Factors

This project provides a method named `printFactors` which prints all the factors of a given integer.

## Method Definition

### `printFactors`

The `printFactors` method takes an integer `number` as a parameter and prints all the factors of that number. If the number is less than 1, the method prints "Invalid Value".

### Parameters

- `number` (int): The integer for which factors need to be printed.

### Returns

- `void`: This method does not return any value; it prints the factors directly.

### Example Input/Output

- `printFactors(6);` → should print:
1
2
3
6
- `printFactors(32);` → should print:
1
2
4
8
16
32
- `printFactors(10);` → should print:
1
2
5
10
- `printFactors(-1);` → should print "Invalid Value" since number is less than 1.

### Notes

- The method `printFactors` should be defined as `public static` as per the course guidelines.
- Do not include a `main` method in the solution code.
