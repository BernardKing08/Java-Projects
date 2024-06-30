# MegaBytes Converter

## `printMegaBytesAndKiloBytes` Method

Write a method called `printMegaBytesAndKiloBytes` that takes one parameter of type `int` named `kiloBytes`.

- This method should not return anything (void) and it needs to calculate the megabytes and remaining kilobytes from the `kiloBytes` parameter.
- Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
  - XX represents the original value `kiloBytes`.
  - YY represents the calculated megabytes.
  - ZZ represents the calculated remaining kilobytes.

For example, when the parameter `kiloBytes` is 2500, it needs to print "2500 KB = 2 MB and 452 KB".

If the parameter `kiloBytes` is less than 0, then print the text "Invalid Value".

### Example Input/Output

- `printMegaBytesAndKiloBytes(2500);` → should print the following text: "2500 KB = 2 MB and 452 KB"
- `printMegaBytesAndKiloBytes(-1024);` → should print the following text: "Invalid Value" because the parameter is less than 0.
- `printMegaBytesAndKiloBytes(5000);` → should print the following text: "5000 KB = 4 MB and 904 KB"

### Tips

- Be extremely careful about spaces in the printed message.
- Use the remainder operator `%`.
- 1 MB = 1024 KB

### Notes

- Do not set the `kiloBytes` parameter value inside your method.
- The `printMegaBytesAndKiloBytes` method needs to be defined as `public static` like we have been doing so far in the course.
- Do not add a `main` method to the solution code.
