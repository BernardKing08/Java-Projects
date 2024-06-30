## Number Palindrome

Write a method called `isPalindrome` with one `int` parameter called `number`.

The method needs to return a `boolean`.

It should return `true` if the number is a palindrome number; otherwise, it should return `false`.

Check the tips below for more info about palindromes.

### Example Input/Output

- `isPalindrome(-1221);` → should return `true`
- `isPalindrome(707);` → should return `true`
- `isPalindrome(11212);` → should return `false` because reverse is 21211 and that is not equal to 11212.

**Tip:** What is a Palindrome number? A palindrome number is a number which, when reversed, is equal to the original number. For example: 121, 12321, 1001, etc.

**Tip:** Logic to check a palindrome number:

1. Find the reverse of the given number. Store it in some variable, say `reverse`.
2. Compare the number with `reverse`.
3. If both are the same, then the number is a palindrome; otherwise, it is not.

**Tip:** Logic to reverse a number:

1. Declare and initialize another variable to store the reverse of a number, for example, `reverse = 0`.
2. Extract the last digit of the given number by performing modulo division (remainder). Store the last digit in some variable, say `lastDigit = num % 10`.
3. Increase the place value of `reverse` by one. To increase place value, multiply the `reverse` variable by 10, e.g., `reverse = reverse * 10`.
4. Add `lastDigit` to `reverse`.
5. Since the last digit of the number is processed, remove the last digit of `num`. To remove the last digit, divide the number by 10.
6. Repeat the steps until the number is not equal to (or greater than) zero.

A while loop would be good for this coding exercise.

**Tip:** Be careful with negative numbers. They can also be palindrome numbers.

**Tip:** Be careful with reversing a number. You will need a parameter for comparing a reversed number with the starting number (parameter).

### Note

- The method `isPalindrome` needs to be defined as `public static` like we have been doing.
- Do not add a main method to the solution code.
