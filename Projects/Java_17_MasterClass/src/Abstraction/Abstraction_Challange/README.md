# Abstract Class Implementation

## 1. ListItem (Abstract Class)
- **Fields:**
  - `protected ListItem rightLink`
  - `protected ListItem leftLink`
  - `protected Object value`

- **Constructor:**
  - Accepts an `Object` parameter and initializes `value` with it.

- **Methods:**
  - `next()`: Abstract method. Returns the next `ListItem`.
  - `setNext(ListItem item)`: Abstract method. Sets `rightLink` and returns it.
  - `previous()`: Abstract method. Returns the previous `ListItem`.
  - `setPrevious(ListItem item)`: Abstract method. Sets `leftLink` and returns it.
  - `compareTo(ListItem item)`: Abstract method. Compares the value of the current item with another item.
  - `getValue()`: Returns the `value`.
  - `set
