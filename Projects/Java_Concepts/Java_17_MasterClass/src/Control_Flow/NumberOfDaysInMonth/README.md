## Number Of Days In Month

Write a method `isLeapYear` with a parameter of type `int` named `year`.

The parameter needs to be greater than or equal to 1 and less than or equal to 9999.

If the parameter is not in that range, return `false`.

Otherwise, if it is in the valid range, calculate if the year is a leap year and return `true` if it is, otherwise return `false`.

A year is a leap year if it is divisible by 4 but not by 100, or it is divisible by 400.

### Examples of Input/Output

- `isLeapYear(-1600);` → should return `false` since the parameter is not in the range (1-9999)
- `isLeapYear(1600);` → should return `true` since 1600 is a leap year
- `isLeapYear(2017);` → should return `false` since 2017 is not a leap year
- `isLeapYear(2000);` → should return `true` because 2000 is a leap year

**NOTE:** The solution to the Leap Year coding exercise earlier in the course created the `isLeapYear` method. You can use that solution if you wish.

Write another method `getDaysInMonth` with two parameters `month` and `year`, both of type `int`.

If the parameter `month` is < 1 or > 12, return -1.

If the parameter `year` is < 1 or > 9999, return -1.

This method needs to return the number of days in the month. Be careful about leap years; they have 29 days in month 2 (February).

You should check if the year is a leap year using the method `isLeapYear`
