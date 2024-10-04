# Reading User Input in Java

## Overview
This Java program reads five valid numbers from the user and calculates their sum. It uses a `Scanner` to read user input from the console and handles invalid input gracefully by prompting the user to enter a valid number until five valid numbers are entered.

## Code Explanation
The program is defined in the `Control_Flow.ReadingUserInput` package and contains a single class `ReadingUserInput` with a `main` method.

### Key Components
- **Scanner**: Used to read input from the console.
- **while Loop**: Repeatedly prompts the user for input until five valid numbers are entered.
- **try-catch Block**: Catches invalid number input and prompts the user to enter a valid number again.

### Program Flow
1. The program initializes a `Scanner` object to read input from the console.
2. It sets a counter (`count`) to 1 and a sum accumulator (`sum`) to 0.
3. Inside a `while` loop that runs until `count` is greater than 5:
    - Prompts the user to enter a valid number.
    - Reads the input as a string.
    - Tries to parse the string to a double. If successful:
        - Adds the number to `sum`.
        - Increments the `count`.
    - If parsing fails (input is not a valid number):
        - Catches the exception and prompts the user to enter a valid number.
4. After successfully reading five valid numbers, prints the sum of the numbers.
5. Closes the `Scanner`.

## Usage
1. **Compile** the program:
    ```bash
    javac Control_Flow/ReadingUserInput/ReadingUserInput.java
    ```
2. **Run** the program:
    ```bash
    java Control_Flow.ReadingUserInput.ReadingUserInput
    ```

### Example
Enter a valid Number: 10
Enter a valid Number: 20.5
Enter a valid Number: abc
Enter a valid number
Enter a valid Number: 15
Enter a valid Number: 5.5
Enter a valid Number: 8
The sum is: 59.0

## Notes
- The program expects the user to input numbers in a valid format (e.g., integers or floating-point numbers).
- Any non-numeric input will trigger the exception handler and prompt the user to enter a valid number again.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

