# Exception Handling 
> is how Java deals with errors that happen while a program is running.
(Think: A safety net — instead of crashing, your program catches the problem and responds)

## What is an Exception?

An **exception** is an event that disrupts the normal flow of a program.

| Without Handling | With Handling |
| --- | --- |
| Program Crashes | Program responds gracefully |

## Key Terminology:

| TERM         | DEFINITION                                       |
|--------------|--------------------------------------------------|
| Exception    | An object representing an error that occurred    |
| Throw        | To signal that an error has occurred             |
| Catch        | To handle an error that was thrown               |
| Stack Trace  | The list of method calles that led to the error  |


---
## The try-catch Block 
```` JAVA
try {
// code that might cause an error
} catch (ExceptionType e) {
// code that runs if that error happens
}
````
**HOW IT WORKS:**
+ Code in `try` runs normally
+ If an error occurs, Java jumps straight to `catch`
+ If no error occurs, `catch` is skipped entirely

---
## finally Block (Optional):
````JAVA
try {
// risky code
} catch (ExceptionType e) {
// handle error
} finally {
// ALWAYS runs, error or not
}
````
It is only used for cleaning up codes either: (IT RUNS NO MATTER WHAT)
+ Closing Files
+ Releasing Sources

---

## Common Built-in Exceptions:
| Exception | When It Happens |
| --- |-----------------|
| `ArithmeticException` | Dividing by zero |
| `NullPointerException` | Using an object that is `null` |
| `ArrayIndexOutOfBoundsException` | Accessing an invalid array index |
| `NumberFormatException` | Converting invalid text to a number |
| `ClassCastException` | Invalid downcasting |

---

## 🔴 `throw` vs `throws`

```java
// throw → Actually creates and fires the exception
throw new Exception("Something went wrong!");
 
// throws → Declares that a method MIGHT throw an exception
public void myMethod() throws Exception { }
```

 📌 **Rule of thumb:**
 - `throw` = the action of throwing
 - `throws` = the warning label on the method
 
---

---

## ✅ Checked vs ❌ Unchecked Exceptions

| Type | Must Handle? | Examples |
|---|---|---|
| **Checked** | ✅ Yes — must catch or declare with `throws` | `IOException`, `Exception` |
| **Unchecked** | ❌ No — optional to handle | `NullPointerException`, `ArithmeticException` |

> Unchecked exceptions are subclasses of `RuntimeException`.
>
---

## 🛠️ Custom Exceptions

You can create your own exception by extending `Exception`:

```java
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message); // passes message to Exception — enables e.getMessage()
    }
}
```

> 💡 Always use `super(message)` — this is what makes `e.getMessage()` work when you catch it!

**Throwing your custom exception:**
```java
throw new InvalidAgeException("Age must be 18 or older");
```

**Catching your custom exception:**
```java
try {
    // risky code
} catch (InvalidAgeException e) {
    System.out.println(e.getMessage());
}
```

## 📋 Key Rules

- A `try` block **must** have at least one `catch` or `finally`
- Multiple `catch` blocks are allowed — catch **specific before general**
- `finally` **always** runs — even with a `return` in `try` or `catch`
- Custom exceptions extend `Exception` *(checked)* or `RuntimeException` *(unchecked)*
- Specific exceptions must be caught **before** the generic `Exception` catch
---

## 🗺️ Quick Visual Summary

```
try {
    ┌─────────────────────────────┐
    │  Code that might fail       │ ──── If error ──→ catch block runs
    │                             │ ──── No error ──→ catch skipped
    └─────────────────────────────┘
}
catch (SpecificException e) { ... }   ← catches specific errors first
catch (Exception e) { ... }           ← catches anything else
finally { ... }                       ← ALWAYS runs no matter what
```