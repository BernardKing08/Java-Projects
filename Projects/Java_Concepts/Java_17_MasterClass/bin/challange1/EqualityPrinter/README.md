# Equality Printer

## Description

The `Equality Printer` is a simple Java method that compares three integer parameters and prints a message based on their equality or difference.

## Method Specification

### Method: `printEqual`

- **Parameters:** 
  - Three integers (`int a, int b, int c`)
- **Return Type:** 
  - `void` (does not return anything)
- **Functionality:** 
  - If any of the parameters is less than 0, print "Invalid Value".
  - If all numbers are equal, print "All numbers are equal".
  - If all numbers are different, print "All numbers are different".
  - Otherwise, print "Neither all are equal or different".

## Examples of Input/Output

- `printEqual(1, 1, 1);` should print: "All numbers are equal"
- `printEqual(1, 1, 2);` should print: "Neither all are equal or different"
- `printEqual(-1, -1, -1);` should print: "Invalid Value"
- `printEqual(1, 2, 3);` should print: "All numbers are different"

## Implementation

```java
public class EqualityPrinter {

    public static void printEqual(int a
