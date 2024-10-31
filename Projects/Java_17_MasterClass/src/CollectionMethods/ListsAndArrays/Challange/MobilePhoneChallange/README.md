## Mobile Phone

Create a program that implements a simple mobile phone with the following capabilities.

### 1. Implement the `MobilePhone` class

The `MobilePhone` class should have the following attributes:

- **Two fields**:
  - A `String` called `myNumber`.
  - An `ArrayList` of type `Contact` called `myContacts`.

- **A constructor**:
  - Takes a `String` (the phone number) and initializes `myNumber` and instantiates `myContacts`.

- **Seven methods**:
  - `addNewContact(Contact contact)`: 
    - **Parameters**: One parameter of type `Contact`.
    - **Returns**: A `boolean`. Returns `true` if the contact doesn't exist, or `false` if the contact already exists.
  
  - `updateContact(Contact oldContact, Contact newContact)`: 
    - **Parameters**: Two parameters of type `Contact` (the old contact to be updated with the new contact).
    - **Returns**: A `boolean`. Returns `true` if the contact exists and was updated successfully, or `false` if the contact doesn't exist.
  
  - `removeContact(Contact contact)`: 
    - **Parameters**: One parameter of type `Contact`.
    - **Returns**: A `boolean`. Returns `true` if the contact exists and was removed successfully, or `false` if the contact doesn't exist.
  
  - `findContact(Contact contact)`: 
    - **Parameters**: One parameter of type `Contact`.
    - **Returns**: An `int`. The returned value is its position in the `ArrayList`, which will either be `-1` (doesn't exist) or a value greater than or equal to `0` (does exist).
  
  - `findContact(String name)`: 
    - **Parameters**: One parameter of type `String`.
    - **Returns**: An `int`. Similar to `findContact(Contact contact)`, but searches by name.
  
  - `queryContact(String name)`: 
    - **Parameters**: One parameter of type `String`.
    - **Returns**: A `Contact`. Use the `String` to search for the name and return the `Contact`. Return `null` otherwise.
  
  - `printContacts()`: 
    - **Parameters**: None.
    - **Returns**: Nothing. Print the contacts in the following format:
    
    ```
    Contact List:
    1. Bob -> 31415926
    2. Alice -> 16180339
    3. Tom -> 11235813
    4. Jane -> 23571113
    ```

### 2. Implement the `Contact` class

The `Contact` class should have the following attributes:

- **Two fields**:
  - Both `String`. One called `name` and the other `phoneNumber`.

- **A constructor**:
  - Takes two `String` values and initializes `name` and `phoneNumber`.

- **Three methods**:
  - `getName()`: Getter for `name`.
  
  - `getPhoneNumber()`: Getter for `phoneNumber`.
  
  - `createContact(String name, String phoneNumber)`: 
    - **Parameters**: Two parameters of type `String` (the person's name and phone number).
    - **Returns**: An instance of `Contact`. This is the only method that is `static
