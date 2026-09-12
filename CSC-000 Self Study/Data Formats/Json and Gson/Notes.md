# **Bonus Lesson: JSON & the Gson Library**

JSON (JavaScript Object Notation) is a plain-text format for storing structured data. Gson is a library (by Google) that converts Java objects into JSON text and back.
(Think: JSON is the *language*, Gson is the *translator* — you don't use one without the other)

---

## **Why JSON instead of Java's built-in `Serializable`?**

Java's `ObjectOutputStream`/`ObjectInputStream` write objects as binary blobs tied tightly to your exact class structure. If you rename a field or change its type later, old saved files can silently fail to load (`InvalidClassException`, `ClassCastException`). JSON is plain text, human-readable, and used by virtually every language and API — not just Java.

```java
import com.google.gson.Gson;         // the core class you'll use
import com.google.gson.JsonSyntaxException; // thrown when a JSON string is malformed
```

Gson is **not** part of the standard library — it must be added to your project manually (as a `.jar`) or via a build tool like Maven/Gradle if you're using one.

---

## **1. Gson (the core class)**

Represents the converter itself — one object handles both directions.

```java
Gson gson = new Gson();
```

**Object → JSON string** (`toJson`):
```java
MileStoneTrackerData data = new MileStoneTrackerData("Chris", "pw123", "2006-12-05");
String json = gson.toJson(data);
// {"Username":"Chris","Password":"pw123","Birthday":"2006-12-05", ...}
```

**JSON string → Object** (`fromJson`):
```java
MileStoneTrackerData restored = gson.fromJson(json, MileStoneTrackerData.class);
```

> ⚠️ `fromJson` needs the **exact class** to rebuild into — pass `ClassName.class`, not an instance.

---

## **2. What Gson Converts Automatically**

Gson inspects your class's fields by reflection — no extra code needed for common types.

```java
String, int, boolean, double, long   // primitives & wrappers
ArrayList<T>, HashMap<K, V>          // standard collections
```

**Example — a class with only "easy" types:**
```java
public class Example {
    private String name;
    private int age;
    private HashMap<Integer, String> notes;
}
```
This converts to/from JSON with zero extra work — just `toJson(obj)` / `fromJson(json, Example.class)`.

---

## **3. What Gson Does *Not* Handle Automatically**

`LocalDate`, `LocalDateTime`, and other `java.time` types have no default JSON representation — Gson doesn't know whether to write them as a string, a number, or an object.

**The simple fix:** store the date as a `String` in the class instead of `LocalDate`, and convert it yourself at the point of use.

```java
private String Birthday; // stored as "2006-12-05"

// when you need it as a real date:
LocalDate birthdayAsDate = LocalDate.parse(Birthday);

// when you're constructing/updating it:
this.Birthday = someLocalDate.toString(); // "2006-12-05"
```

> 💡 The more advanced fix is a custom `TypeAdapter<LocalDate>` registered on the `Gson` object — worth learning later, not required to get JSON working today.

---

## **4. Reading & Writing Files**

Gson only converts object ↔ string. Getting that string in/out of a file is plain Java I/O — same as you'd do with any text file.

**Writing:**
```java
String json = gson.toJson(data);
Files.writeString(Path.of("save.json"), json);
```

**Reading:**
```java
String json = Files.readString(Path.of("save.json"));
MileStoneTrackerData data = gson.fromJson(json, MileStoneTrackerData.class);
```

> ⚠️ `Files.writeString`/`readString` throw `IOException` — wrap them the same way you already do for your existing file operations.

---

## **5. Handling Bad/Corrupted JSON**

If a file's content isn't valid JSON (manually edited, cut off mid-write, etc.), `fromJson` throws a `JsonSyntaxException`.

```java
try {
    MileStoneTrackerData data = gson.fromJson(json, MileStoneTrackerData.class);
} catch (JsonSyntaxException e) {
    System.out.println("[ERROR] This save file is corrupted or invalid.");
}
```

---

## **6. Pretty-Printing (optional, but nice for debugging)**

By default, `toJson` produces compact, single-line output. `GsonBuilder` lets you configure a Gson instance to output readable, indented JSON instead.

```java
Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
String json = prettyGson.toJson(data);
```

```json
{
  "Username": "Chris",
  "Age": 19,
  "Birthday": "2006-12-05"
}
```

instead of:
```json
{"Username":"Chris","Age":19,"Birthday":"2006-12-05"}
```

Functionally identical — purely for making the file readable when you open it yourself.

---

## **📋 Key Rules:**

- Gson is a library, not part of the standard library — it must be added to your project manually
- `toJson(object)` → String, `fromJson(string, Class)` → object — that's the entire core API
- Primitives, `String`, `ArrayList`, and `HashMap` convert automatically — no extra code
- `java.time` types (`LocalDate`, etc.) do **not** convert automatically — store as `String` and parse manually, or write a `TypeAdapter`
- Always catch `JsonSyntaxException` when loading, the same way you'd catch `IOException`

---

## **🗺️ Quick Reference:**

```
Need to save an object as JSON?     → gson.toJson(object)
Need to load JSON into an object?   → gson.fromJson(json, Class.class)
Field is a primitive/String/Map?    → works automatically
Field is a LocalDate/LocalDateTime? → store as String, parse manually
Want readable/indented output?      → new GsonBuilder().setPrettyPrinting().create()
Loading might fail?                 → catch JsonSyntaxException
```