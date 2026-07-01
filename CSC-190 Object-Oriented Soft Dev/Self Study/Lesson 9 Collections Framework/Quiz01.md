# 📝 Lesson 9 Quiz — Collections Framework

---

## 📌 Instructions
- Read each question carefully
- Choose the **best answer** from the options provided
- Fill in your answers in the **My Answers** section at the bottom

---

## ❓ Questions

---

### Question 1
Which collection automatically rejects duplicate values?

- A) `ArrayList`
- B) `HashMap`
- C) `HashSet`
- D) `LinkedList`

---

### Question 2
What does `ArrayList.get(index)` do?

- A) Removes the element at that index
- B) Returns the element at that index
- C) Checks if the index exists
- D) Adds an element at that index

---

### Question 3
In a `HashMap<String, Integer>`, what happens if you `put()` a key that already exists?

- A) It throws an exception
- B) It adds a duplicate key-value pair
- C) It overwrites the existing value for that key
- D) It is ignored completely

---

### Question 4
What does `keySet()` return when called on a HashMap?

- A) A list of all the values
- B) A list of all the keys
- C) The size of the HashMap
- D) A boolean indicating if the map is empty

---

### Question 5
What will this code print?

```java
HashSet<String> set = new HashSet<>();
set.add("Apple");
set.add("Apple");
set.add("Banana");
System.out.println(set.size());
```

- A) 1
- B) 2
- C) 3
- D) 0

---

### Question 6
What is the main difference between `ArrayList` and `HashSet`?

- A) ArrayList allows duplicates and is ordered, HashSet does not allow duplicates and is unordered
- B) ArrayList does not allow duplicates, HashSet does
- C) They are exactly the same
- D) HashSet can only store numbers

---

### Question 7
What does `HashMap.containsKey("Alice")` do?

- A) Adds "Alice" as a key
- B) Removes "Alice" if she exists
- C) Returns true/false depending on whether "Alice" exists as a key
- D) Returns the value associated with "Alice"

---

### Question 8
Why would you choose a `HashMap` over an `ArrayList` for storing student grades?

- A) HashMap is always faster regardless of use case
- B) HashMap allows instant lookup by student name instead of searching through a list
- C) ArrayList cannot store grades
- D) HashMap automatically sorts the grades

---

### Question 9
What does this code do?

```java
ArrayList<String> list = new ArrayList<>();
list.add("Dog");
list.add("Cat");
boolean removed = list.remove("Fish");
```

- A) Throws an exception because "Fish" doesn't exist
- B) `removed` becomes `true`
- C) `removed` becomes `false` because "Fish" was never in the list
- D) The program crashes

---

### Question 10
When using `HashMap<String, ArrayList<String>>`, what happens when you call `.get(key)` on an existing key and then `.add()` on the result?

- A) It creates a brand new ArrayList
- B) It modifies the same ArrayList object stored in the HashMap directly
- C) It throws a NullPointerException
- D) Nothing happens, you must use `.put()` again

---

## ✏️ My Answers

| Question | My Answer |
|----------|-----------|
| 1        | C         |
| 2        | B         |
| 3        | C         |
| 4        | B         |
| 5        | B         |
| 6        | A         |
| 7        | C         |
| 8        | B         |
| 9        | C         |
| 10       | B         |

---

## ✅ Correct Answers
*(Fill this in after receiving feedback from Professor Claude)*

| Question | Correct Answer | Explanation |
|----------|----------------|-------------|
| 1        |                |             |
| 2        |                |             |
| 3        |                |             |
| 4        |                |             |
| 5        |                |             |
| 6        |                |             |
| 7        |                |             |
| 8        |                |             |
| 9        |                |             |
| 10       |                |             |