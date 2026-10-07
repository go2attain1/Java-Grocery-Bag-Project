# Java Grocery Bag Project

## Grocery Bag: Array-Based Bag Data Structure

A Java project demonstrating the bag (multiset) abstract data type, implemented with
an array. A bag stores items with no ordering and allows duplicates, which makes
equality and set-style operations more interesting than in a plain list.

## Overview

| Type | Kind | Description |
|------|------|-------------|
| `BagADT` | Interface | Defines add, remove, contains, isEmpty, and size |
| `ArrayBasedBag` | Class | Implements `BagADT` with a fixed-capacity `String[]`; adds `contents()`, `occurrence()`, and `toString()` |
| `GroceryBag` | Class | Extends `ArrayBasedBag` with `equals()` and `intersection()` |

## Key Behavior

**Equality is order-independent.** Two bags are equal if they hold the same items
with the same number of occurrences, regardless of arrangement.

[chicken, chicken, pasta, pasta, yogurt] equals [pasta, yogurt, chicken, pasta, chicken]

**Intersection keeps the minimum count of each item.**

intersection({a, a, a, b}, {a, a, b, b}) -> {a, a, b}


## Concepts Demonstrated

- **Abstract data types**: separating the `BagADT` interface from its array-based
  implementation
- **Inheritance**: `GroceryBag` reuses the bag implementation and adds new behavior
- **Overriding `equals()`**: handles self, null, different class, different size, and
  differing item counts
- **Counting with a HashMap**: both methods track already-processed items so each
  distinct item is only evaluated once
- **Constant-time removal**: `remove()` swaps in the last element instead of shifting
- **Unit testing**: tests for equality (ordered and unordered) and for intersection,
  including empty and non-overlapping bags

## Project Structure

groceries/

├── BagADT.java

├── ArrayBasedBag.java

├── ArrayBasedBagTest.java

├── GroceryBag.java

└── GroceryBagTest.java


## Running the Tests

The tests extend `student.TestCase`, so `student.jar` must be on your classpath.

1. Create a Java project and a package named `groceries`
2. Place all five `.java` files in that package
3. Add `student.jar` to the project's build path
4. Run `ArrayBasedBagTest` and `GroceryBagTest` as JUnit tests

## Example Usage

```java
GroceryBag a = new GroceryBag();
a.add("chicken");
a.add("chicken");
a.add("pasta");

GroceryBag b = new GroceryBag();
b.add("pasta");
b.add("chicken");

a.intersection(b);   // [chicken, pasta]
a.equals(b);         // false (different sizes)
a.occurrence("chicken");  // 2
```
