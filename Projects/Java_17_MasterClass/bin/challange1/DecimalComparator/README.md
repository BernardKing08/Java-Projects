# DecimalComparator

## `areEqualByThreeDecimalPlaces` Method

Write a method called `areEqualByThreeDecimalPlaces` with two parameters of type `double`.

- The method should return a boolean and it needs to return `true` if two double numbers are the same up to three decimal places. Otherwise, return `false`.

### Examples of input/output:

- `areEqualByThreeDecimalPlaces(-3.1756, -3.175);` → should return `true` since numbers are equal up to 3 decimal places.
- `areEqualByThreeDecimalPlaces(3.175, 3.176);` → should return `false` since numbers are not equal up to 3 decimal places.
- `areEqualByThreeDecimalPlaces(3.0, 3.0);` → should return `true` since numbers are equal up to 3 decimal places.
- `areEqualByThreeDecimalPlaces(-3.123, 3.123);` → should return `false` since numbers are not equal up to 3 decimal places.

### Tips

- Use paper and pencil.
- Use casting.

### Notes

- The `areEqualByThreeDecimalPlaces` method needs to be defined as `public static` like we have been doing so far in the course.
- Do not add a `main` method to the solution code.
