# Minimum Element

## Method: readInteger()
- **Signature**: `private static int readInteger()`
- **Description**: Reads an integer from the user, which represents how many elements the user needs to enter.

## Method: readElements()
- **Signature**: `private static int[] readElements(int numberOfElements)`
- **Parameter**: `int numberOfElements` - The number of elements to read from the console.
- **Description**: Reads the specified number of elements from the console and returns them in an array.

## Method: findMin()
- **Signature**: `private static int findMin(int[] array)`
- **Parameter**: `int[] array` - The array of integers.
- **Description**: Returns the minimum value in the given array.

## Scenario
1. `readInteger()` is called.
2. The number returned by `readInteger()` is used to call `readElements()`.
3. The array returned from `readElements()` is used to call `findMin()`.
4. `findMin()` returns the minimum number.

> **Note**: Do not try to implement this. It is to give you an idea of how the methods will be used.

## Tips
- Assume that the user will only enter numbers, never letters.
- Instantiate the `Scanner` object inside the method. There should be two `Scanner` objects, one for each method that reads input from the user.
- Be extremely careful about spaces in the printed messages.

## Notes
- All methods should be defined as `private static`.
- Do not add a `main` method to the solution code.
- Classes that are not in the `java.lang` package should be manually imported.
