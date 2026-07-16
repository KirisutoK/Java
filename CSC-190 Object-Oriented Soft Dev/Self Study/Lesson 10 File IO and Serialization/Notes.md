# **Lesson 10: File I/O and Serialization**

File I/O lets your program **save data to files and read data from files**.
(Think: Without File I/O, your program forgets everything when it closes — File I/O gives it memory)

---

## **What is File I/O?**

- **I/O** stands for **Input/Output**
- **Input** = reading data FROM a file into your program
- **Output** = writing data FROM your program INTO a file
- Java handles this through classes in `java.io` and `java.nio` packages

```java
import java.io.*;       // classic File I/O
import java.nio.*;      // modern File I/O (we'll focus on java.io)
```

---

## **Key Classes You'll Use:**

| Class | Purpose |
|---|---|
| `File` | Represents a file or folder on disk |
| `FileWriter` | Writes text to a file |
| `FileReader` | Reads text from a file |
| `BufferedWriter` | Writes text efficiently (buffered) |
| `BufferedReader` | Reads text efficiently line by line |
| `PrintWriter` | Writes formatted text to a file |

## **Writer Classes:**

| Class              | Purpose                                           |
|--------------------|---------------------------------------------------|
| `FileWriter`       | Good for small or medium-sized text files         |
| `BufferedWriter`   | Better performance for large amounts of text      |
| `PrintWriter`      | Best for structured data, like reports or logs    |
| `FileOutputStream` | Best for binary files (e.g., images, audio files) |

## **Reader Classes:**

| Class                         | Purpose                                               |
|-------------------------------|-------------------------------------------------------|
| `BufferedReader`+`FileReader` | Best for reading text files line-by-line              |
| `FileInputStream`             | Best for binary files (e.g., images, audio files)     |
| `RandomAccessFile`            | Best for read/write specific portions of a large file |

---

## **Writing to a File:**

```java
// Using FileWriter + BufferedWriter
FileWriter fw = new FileWriter("myfile.txt");
BufferedWriter bw = new BufferedWriter(fw);
bw.write("Hello, File!");
bw.newLine();           // adds a new line
bw.write("Second line");
bw.close();             // ALWAYS close when done!

// Shortcut using PrintWriter
PrintWriter pw = new PrintWriter("myfile.txt");
pw.println("Hello, File!");
pw.println("Second line");
pw.close();
```

---

## **Reading from a File:**

```java
// Using FileReader + BufferedReader
FileReader fr = new FileReader("myfile.txt");
BufferedReader br = new BufferedReader(fr);

String line;
while ((line = br.readLine()) != null) {  // reads line by line until end of file
    System.out.println(line);
}
br.close();             // ALWAYS close when done!
```

---

## **Append vs Overwrite:**

```java
// Overwrite (default) — replaces existing content
FileWriter fw = new FileWriter("myfile.txt");

// Append — adds to existing content
FileWriter fw = new FileWriter("myfile.txt", true);  // true = append mode
```

---

## **The File Class:**

```java
File file = new File("myfile.txt");

file.exists();          // returns true if file exists
file.createNewFile();   // creates the file if it doesn't exist
file.delete();          // deletes the file
file.getName();         // returns "myfile.txt"
file.length();          // returns file size in bytes
file.isFile();          // returns true if it's a file
file.isDirectory();     // returns true if it's a folder
```

---

## **try-with-resources (The Modern Way):**

Instead of manually calling `.close()`, Java can close files automatically:

```java
try (BufferedWriter bw = new BufferedWriter(new FileWriter("myfile.txt"))) {
    bw.write("Hello!");
    bw.newLine();
}
// file is automatically closed here — no need for bw.close()!
```

This is the **preferred modern approach** — cleaner and safer!

---

## **What is Serialization?**

Serialization lets you **save entire Java objects to a file** and **load them back later**.
(Think: Instead of saving just text, you save the whole object — all its variables and state)

```java
// To make a class serializable, implement Serializable
public class Student implements Serializable {
    private String name;
    private int age;
    // ...
}
```

**Saving an object (Serialization):**
```java
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"));
oos.writeObject(student);   // saves the entire object!
oos.close();
```

**Loading an object (Deserialization):**
```java
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"));
Student student = (Student) ois.readObject();   // loads the entire object!
ois.close();
```

---

## **Key Rules:**

- Always **close** your file streams when done — or use try-with-resources
- File I/O throws `IOException` — always handle it with try-catch or `throws`
- `BufferedReader/Writer` is faster than `FileReader/Writer` alone — always prefer buffered
- Serialization requires the class to `implement Serializable`
- The `.ser` extension is convention for serialized files (not required)
- If a class has a field you DON'T want serialized, mark it `transient`

```java
private transient String password;  // this field won't be saved to file
```

---

## **Common Mistakes:**

- Forgetting to call `.close()` → file might not save properly
- Not handling `IOException` → won't compile
- Trying to serialize a class that doesn't implement `Serializable` → runtime error
- Opening a file for writing without append mode → accidentally deletes existing content

---

## **Quick Reference:**

```
Write text to file    → PrintWriter or BufferedWriter
Read text from file   → BufferedReader
Save whole object     → ObjectOutputStream (Serialization)
Load whole object     → ObjectInputStream (Deserialization)
Check file exists     → File.exists()
Auto-close files      → try-with-resources
```