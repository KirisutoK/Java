# **Lesson 9: Collections Framework**

Collections are **resizable, flexible data structures** that replace fixed-size arrays.
(Think: Arrays are a fixed-size box, Collections are a bag that grows and shrinks as needed)

---

## **What is the Collections Framework?**

A set of built-in Java classes and interfaces for storing and managing groups of objects.

```java
import java.util.*;  // imports everything in Collections Framework
```

---

## **The Most Important Collections:**

| Collection | Like a... | Allows Duplicates | Ordered | Key Feature |
|---|---|---|---|---|
| `ArrayList` | Growable array | ✅ Yes | ✅ Yes | Fast access by index |
| `LinkedList` | Chain of nodes | ✅ Yes | ✅ Yes | Fast add/remove |
| `HashSet` | Bag of unique items | ❌ No | ❌ No | No duplicates |
| `HashMap` | Dictionary | ❌ Keys unique | ❌ No | Key-value pairs |
| `Stack` | Stack of plates | ✅ Yes | ✅ Yes | Last in, first out |

---

## **ArrayList — The Most Common:**

```java
ArrayList<String> list = new ArrayList<>();
list.add("Apple");          // add item
list.get(0);                // get by index
list.remove(0);             // remove by index
list.size();                // how many items
list.contains("Apple");     // check if exists
list.clear();               // remove all
```

---

## **HashMap — Key-Value Pairs:**

```java
HashMap<String, Integer> map = new HashMap<>();
map.put("Alice", 95);       // add key-value pair
map.get("Alice");           // get value by key → 95
map.containsKey("Alice");   // check if key exists
map.remove("Alice");        // remove by key
map.size();                 // how many pairs
```

---

## **HashSet — Unique Items Only:**

```java
HashSet<String> set = new HashSet<>();
set.add("Apple");           // add item
set.add("Apple");           // ignored — already exists!
set.contains("Apple");      // check if exists
set.remove("Apple");        // remove item
set.size();                 // how many items
set.addAll(v);              // adds all items from another item 
```

---

## **Looping Through Collections:**

```java
// Enhanced for loop (works for all collections)
for (String item : list) {
    System.out.println(item);
}

// Loop through HashMap
for (String key : map.keySet()) {
    System.out.println(key + " → " + map.get(key));
}
```

---

## **Generics `<T>`:**

The `<String>`, `<Integer>` you see in collections is called **Generics** — it tells Java what TYPE the collection holds.

```java
ArrayList<String> names = new ArrayList<>();    // only Strings
ArrayList<Integer> numbers = new ArrayList<>();  // only Integers
ArrayList<Student> students = new ArrayList<>(); // only Student objects
```

---

## **Key Rules:**
- Collections only store **objects**, not primitives — use `Integer` not `int`, `Double` not `double`
- `ArrayList` index starts at 0, just like arrays
- `HashMap` keys must be unique — adding same key overwrites the old value
- `HashSet` automatically rejects duplicates
- Always import `java.util.*` or the specific class you need