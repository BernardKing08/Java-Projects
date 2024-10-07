# Banking Application

Your job is to create a simple banking application.

## Classes and Specifications

### 1. Bank

- **Fields:**
  - `name`: A `String` representing the name of the bank.
  - `branches`: An `ArrayList` that holds objects of type `Branch`.

- **Constructor:**
  - `Bank(String name)`: Initializes the `name` and instantiates `branches`.

- **Methods:**
  - `boolean addBranch(String branchName)`: Adds a branch to the bank. Returns `true` if the branch was added successfully, `false` otherwise.
  - `boolean addCustomer(String branchName, String customerName, double initialTransaction)`: Adds a customer to a specified branch. Returns `true` if the customer was added successfully, `false` otherwise.
  - `boolean addCustomerTransaction(String branchName, String customerName, double transaction)`: Adds a transaction to a customer's account at a specified branch. Returns `true` if the transaction was added successfully, `false` otherwise.
  - `Branch findBranch(String branchName)`: Finds and returns a branch by its name. Returns `null` if the branch does not exist.
  - `boolean listCustomers(String branchName, boolean printTransactions)`: Lists customers of a specified branch. If `printTransactions` is `true`, prints transactions; otherwise, only lists customers. Returns `true` if the branch exists, `false` otherwise.

### 2. Branch

- **Fields:**
  - `name`: A `String` representing the name of the branch.
  - `customers`: An `ArrayList` that holds objects of type `Customer`.

- **Constructor:**
  - `Branch(String name)`: Initializes the `name` and instantiates `customers`.

- **Methods:**
  - `String getName()`: Returns the name of the branch.
  - `ArrayList<Customer> getCustomers()`: Returns the list of customers in the branch.
  - `boolean newCustomer(String customerName, double initialTransaction)`: Adds a new customer to the branch. Returns `true` if the customer was added successfully, `false` otherwise.
  - `boolean addCustomerTransaction(String customerName, double transaction)`: Adds a transaction to a customer's account. Returns `true` if the transaction was added successfully, `false` otherwise
