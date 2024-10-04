# Bank Account Management

## Description

This project contains a simple bank account management system with the following two classes:

1. `Account`
2. `ClassesChallenge`

## Account Class

The `Account` class manages the details of a bank account. It includes the following fields:

- `accountNumber` (String): The account number.
- `accountBalance` (double): The account balance.
- `customerName` (String): The name of the customer.
- `email` (String): The email address of the customer.
- `phoneNumber` (String): The phone number of the customer.

### Constructor

Initializes an `Account` object with the given details.

### Methods

1. **getAccountNumber**
   - **Parameters:** None
   - **Returns:** The account number.

2. **setAccountNumber**
   - **Parameters:** `String accountNumber`
   - **Action:** Sets the account number.

3. **getAccountBalance**
   - **Parameters:** None
   - **Returns:** The account balance.

4. **setAccountBalance**
   - **Parameters:** `double accountBalance`
   - **Action:** Sets the account balance.

5. **getCustomerName**
   - **Parameters:** None
   - **Returns:** The customer name.

6. **setCustomerName**
   - **Parameters:** `String customerName`
   - **Action:** Sets the customer name.

7. **getEmail**
   - **Parameters:** None
   - **Returns:** The email address.

8. **setEmail**
   - **Parameters:** `String email`
   - **Action:** Sets the email address.

9. **getPhoneNumber**
   - **Parameters:** None
   - **Returns:** The phone number.

10. **setPhoneNumber**
    - **Parameters:** `String phoneNumber`
    - **Action:** Sets the phone number.

11. **depositMoney**
    - **Parameters:** `double amount`
    - **Action:** Deposits the specified amount into the account. Prints an error message if the amount is negative.

12. **withdrawMoney**
    - **Parameters:** `double amount`
    - **Action:** Withdraws the specified amount from the account if it doesn't cause a negative balance. Prints the balance or an error message if the withdrawal is not allowed.

## ClassesChallenge Class

The `ClassesChallenge` class contains the `main` method to demonstrate the functionality of the `Account` class.

### Main Method

- Creates an `Account` object with initial values.
- Displays the account balance.
- Attempts to withdraw an amount greater than the balance.
- Attempts to withdraw a valid amount.

### Example Usage

Demonstrates the creation of an account, checking the balance, and attempting both valid and invalid withdrawals.
