# Complex Operations

## Description

A complex number is a number that can be expressed in the form \(a + bi\), where \(a\) and \(b\) are real numbers, and \(i\) is a solution of the equation \(x^2 = -1\). Because no real number satisfies this equation, \(i\) is called an imaginary number. For the complex number \(a + bi\), \(a\) is called the real part, and \(b\) is called the imaginary part. To add or subtract two complex numbers, just add or subtract the corresponding real and imaginary parts. For instance, the sum of \(5 + 3i\) and \(4 + 2i\) is \(9 + 5i\). For another, the sum of \(3 + i\) and \(-1 + 2i\) is \(2 + 3i\).

## ComplexNumber Class

The `ComplexNumber` class represents a complex number with a real and imaginary part.

### Fields

- `real` (double): The real part of the complex number.
- `imaginary` (double): The imaginary part of the complex number.

### Constructor

#### Parameterized Constructor
- **Parameters:** `double real`, `double imaginary`
- Initializes the `ComplexNumber` object with the given real and imaginary parts.

### Methods

#### getReal
- **Parameters:** None
- **Returns:** The value of the `real` field.

#### getImaginary
- **Parameters:** None
- **Returns:** The value of the `imaginary` field.

#### add
- **Parameters:** `double real`, `double imaginary`
- Adds the provided real and imaginary values to the corresponding fields.

#### add
- **Parameters:** `ComplexNumber other`
- Adds the real and imaginary parts of the provided `ComplexNumber` to the corresponding fields.

#### subtract
- **Parameters:** `double real`, `double imaginary`
- Subtracts the provided real and imaginary values from the corresponding fields.

#### subtract
- **Parameters:** `ComplexNumber other`
- Subtracts the real and imaginary parts of the provided `ComplexNumber` from the corresponding fields.
