# **Supplementary: Working with JSON using Gson**

JSON (JavaScript Object Notation) is the most common format for storing and exchanging data in modern software.
(Think: Instead of saving a binary `.ser` file that only Java can read, you save a `.json` file that any language, tool, or human can read)

---

## **What is JSON?**

A lightweight, human-readable format for storing structured data using key-value pairs.

```json
{
  "name": "John Smith",
  "age": 19,
  "enrolled": true,
  "courses": ["Java", "Math", "English"]
}
```

A **JSON array** is a list of objects:

```json
[
  { "name": "John Smith", "age": 19 },
  { "name": "Jane Doe", "age": 21 }
]
```

---

## **1. What is Gson?**

Gson is a Google library that converts between Java objects and JSON in both directions.

| Term | Meaning |
|---|---|
| **Serialization** | Java object → JSON String/file |
| **Deserialization** | JSON String/file → Java object |

```java
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
```

---

## **2. Basic Serialization (Object → JSON)**

```java
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

```java
Gson gson = new Gson();
Student student = new Student("John Smith", 19);

String json = gson.toJson(student);
System.out.println(json);
// Output: {"name":"John Smith","age":19}
```

**Pretty printing (formatted, readable output):**
```java
Gson gson = new GsonBuilder().setPrettyPrinting().create();
String json = gson.toJson(student);
// Output:
// {
//   "name": "John Smith",
//   "age": 19
// }
```

> 💡 Always use `GsonBuilder` with `.setPrettyPrinting()` when saving to a file — it makes the JSON human-readable and easier to debug.

---

## **3. Basic Deserialization (JSON → Object)**

```java
String json = "{\"name\":\"John Smith\",\"age\":19}";

Gson gson = new Gson();
Student student = gson.fromJson(json, Student.class);

System.out.println(student.getName()); // John Smith
```

> ⚠️ Your class fields must match the JSON keys exactly — Gson maps them by name. If they don't match, the field will be `null` or `0`.

---

## **4. Saving JSON to a File**

This is where it connects to what you already know from File I/O (Lesson 10):

```java
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public static void saveToFile(Object obj, String filename) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    try (FileWriter fw = new FileWriter(filename)) {
        gson.toJson(obj, fw); // writes JSON directly to the file
    } catch (IOException e) {
        System.out.println("Error saving file: " + e.getMessage());
    }
}
```

---

## **5. Loading JSON from a File**

```java
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public static Student loadFromFile(String filename) {
    Gson gson = new Gson(); // Creates the object in order to use the method
    
    String JSON_Data; // Get the data of the JSON file and put it into a string.
    try {
        JSON_Data = Files.readString(Path.of(File.getpath));
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    
    return gson.fromJson(JSON_Data, Student.class); // Use the string to make the object.
}
```

---

## **6. Working with Lists**

Saving and loading a `List` of objects requires one extra step — a `TypeToken` — because Java erases generic type information at runtime and Gson needs a hint.

**Saving a List:**
```java
List<Student> students = new ArrayList<>();
students.add(new Student("John", 19));
students.add(new Student("Jane", 21));

Gson gson = new GsonBuilder().setPrettyPrinting().create();
try (FileWriter fw = new FileWriter("students.json")) {
    gson.toJson(students, fw);
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

**Loading a List:**
```java
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

Type listType = new TypeToken<List<Student>>(){}.getType();

Gson gson = new Gson();
try (FileReader fr = new FileReader("students.json")) {
    List<Student> students = gson.fromJson(fr, listType);
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

> ⚠️ `TypeToken` is the only time you'll write code that looks unusual — the `{}` at the end creates an anonymous subclass so Gson can read the generic type at runtime. You don't need to understand the internals deeply — just know this is the pattern for deserializing any generic type like `List<T>` or `Map<K,V>`.

---

## **7. Gson and LocalDate / LocalDateTime**

Gson does **not** natively support `java.time` classes — it doesn't know how to serialize `LocalDate`, `LocalDateTime`, etc. out of the box. You have two options:

**Option A — Store dates as Strings (simplest):**
Store your date as a formatted String in your class, and convert it back to `LocalDate` manually when needed.

```java
public class Event {
    private String name;
    private String dateTime; // store as "2026-08-20 14:30:00"
}
```

**Option B — Register a custom TypeAdapter (recommended for your project):**
Tell Gson exactly how to serialize and deserialize `LocalDateTime`.

```java
import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.format(dtf));
    }

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        return LocalDateTime.parse(json.getAsString(), dtf);
    }
}
```

**Registering the adapter with Gson:**
```java
Gson gson = new GsonBuilder()
    .setPrettyPrinting()
    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
    .create();
```

> 💡 For your final project, create one adapter per `java.time` type you use (`LocalDate`, `LocalDateTime`, `ZonedDateTime`) and register them all in one place — then reuse that same `Gson` instance everywhere in your app.

---

## **📋 Key Rules:**

- Always use `try-with-resources` when reading/writing JSON files — same as regular File I/O
- Use `GsonBuilder` with `.setPrettyPrinting()` for file output — raw `new Gson()` is fine for quick in-memory conversions
- Field names in your Java class must match JSON keys exactly
- For `List<T>` or any generic type, always use `TypeToken` when deserializing
- Gson ignores `null` fields by default when serializing — use `.serializeNulls()` on `GsonBuilder` if you need them included
- Create a custom `TypeAdapter` for any `java.time` class you use

---

## **🗺️ Quick Reference:**

```
Java Object → JSON String      → gson.toJson(object)
JSON String → Java Object      → gson.fromJson(json, MyClass.class)

Java Object → JSON File        → gson.toJson(object, fileWriter)
JSON File   → Java Object      → gson.fromJson(fileReader, MyClass.class)

List → JSON File               → gson.toJson(list, fileWriter)
JSON File → List               → gson.fromJson(fileReader, new TypeToken<List<MyClass>>(){}.getType())

java.time support              → register a custom TypeAdapter via GsonBuilder
Pretty output                  → new GsonBuilder().setPrettyPrinting().create()
```