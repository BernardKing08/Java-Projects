# Person

## Description

Write a class with the name `Person`. The class needs three fields (instance variables) with the names `firstName`, `lastName` of type `String`, and `age` of type `int`.

## Person Class

The `Person` class represents an individual with basic information such as first name, last name, and age.

### Fields

- `firstName` (String): The first name of the person.
- `lastName` (String): The last name of the person.
- `age` (int): The age of the person.

### Methods

#### getFirstName
- **Parameters:** None
- **Returns:** The value of the `firstName` field.

#### getLastName
- **Parameters:** None
- **Returns:** The value of the `lastName` field.

#### getAge
- **Parameters:** None
- **Returns:** The value of the `age` field.

#### setFirstName
- **Parameters:** `String firstName`
- **Action:** Sets the value of the `firstName` field.

#### setLastName
- **Parameters:** `String lastName`
- **Action:** Sets the value of the `lastName` field.

#### setAge
- **Parameters:** `int age`
- **Action:** Sets the value of the `age` field. If the parameter is less than 0 or greater than 100, it sets the age field value to 0.

#### isTeen
- **Parameters:** None
- **Returns:** True if the age is greater than 12 and less than 20, otherwise false.

#### getFullName
- **Parameters:** None
- **Returns:** The full name of the person.
  - If both `firstName` and `lastName` are empty strings, returns an empty string.
  - If `lastName` is an empty string, returns `firstName`.
  - If `firstName` is an empty string, returns `lastName`.
