# 📝 Lesson 8 Quiz — Exception Handling

---

## 📌 Instructions
- Read each question carefully
- Choose the **best answer** from the options provided
- Fill in your answers in the **My Answers** section at the bottom

---

## ❓ Questions

---

### Question 1
What is the correct keyword to **manually trigger** an exception in Java?

- A) `catch`
- B) `throws`
- C) `throw`
- D) `exception`

---

### Question 2
What is the difference between `throw` and `throws`?

- A) They are the same thing, just different spelling
- B) `throw` triggers an exception, `throws` declares a method might throw one
- C) `throws` triggers an exception, `throw` declares a method might throw one
- D) `throws` is used inside a method, `throw` is used in the method signature

---

### Question 3
What does the `finally` block do?

- A) Runs only when an exception is caught
- B) Runs only when no exception occurs
- C) Runs only when the program crashes
- D) Always runs regardless of whether an exception occurred or not

---

### Question 4
Which of the following is a **Checked Exception**?

- A) `NullPointerException`
- B) `ArithmeticException`
- C) `ArrayIndexOutOfBoundsException`
- D) `Exception`

---

### Question 5
What will this code print?

```java
try {
    int result = 10 / 0;
    System.out.println("A");
} catch (ArithmeticException e) {
    System.out.println("B");
} finally {
    System.out.println("C");
}
```

- A) A, C
- B) B
- C) B, C
- D) A, B, C

---

### Question 6
How do you create a **custom exception** in Java?

- A) `public class MyException implements Exception`
- B) `public class MyException extends RuntimeException` or `extends Exception`
- C) `public class MyException throws Exception`
- D) `public exception MyException extends Exception`

---

### Question 7
What is the correct order of `catch` blocks when catching multiple exceptions?

- A) General exceptions first, specific exceptions last
- B) It doesn't matter, Java handles the order automatically
- C) Specific exceptions first, general exceptions last
- D) Alphabetical order

---

### Question 8
What does `e.getMessage()` return?

- A) The type of the exception
- B) The line number where the exception occurred
- C) The message passed into the exception's constructor via `super()`
- D) The full stack trace of the exception

---

### Question 9
What happens if an exception is thrown inside a `try` block but there is **no matching `catch` block**?

- A) The program ignores the exception and continues
- B) The `finally` block runs and then the exception propagates up the call stack
- C) Java automatically handles it silently
- D) The program restarts from the beginning

---

### Question 10
Which exception would be thrown by this code?

```java
String[] arr = null;
System.out.println(arr[0]);
```

- A) `ArrayIndexOutOfBoundsException`
- B) `IllegalArgumentException`
- C) `ArithmeticException`
- D) `NullPointerException`

---

## ✏️ My Answers

| Question | My Answer |
|----------|-----------|
| 1        | C ✅       |
| 2        | B     ✅   |
| 3        | D     ✅   |
| 4        | D     ✅   |
| 5        | C     ✅   |
| 6        | B     ✅   |
| 7        | B     ❌   |
| 8        | C     ✅   |
| 9        | A     ❌   |
| 10       | D     ✅   |

---

## ✅ Correct Answers
*(Fill this in after receiving feedback from Professor Claude)*

| Question | Correct Answer   | Explanation                                       |
|----------|------------------|---------------------------------------------------|
| 1        | C       ✅        |  `throw `                                         |
| 2        | B          ✅     | `throw` triggers, `throws` declares               |
| 3        | D             ✅  | Always runs                                       |
| 4        | D  ✅             | `Exception`                                       |
| 5        | C   ✅            | B, C                                              |
| 6        | B        ✅       | `extends Exception` or `extends RuntimeException` |
| 7        | C           ❌    | Specific first, general last                      |
| 8        | C              ✅ | Message from super()                              |
| 9        | B ❌              | `finally` runs, then exception propagates         |
| 10       | A    ✅           | `NullPointerException`                            |