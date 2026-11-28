# ChronoSuite

A multi-application **Java console productivity suite** built around the Java **Date and Time API**. Track life milestones and subscriptions, with password-protected **JSON save files** and per-file activity logs.

> **Status:** Work in progress. This is the CLI (console) version of ChronoSuite.

---

## Applications

| App | Status | What it does |
|-----|--------|--------------|
| **MileStone Tracker** | ✅ Working | Tracks **age-based** milestones (e.g., "Age 21: graduate college") and **day-based** milestones (e.g., "Day 10,000 alive"), calculated from your birthday |
| **Subscription Tracker** | ✅ Working | Stores subscriptions with name, price, billing cycle and start date (today or an earlier date) |
| **Work Hours Tracker** | 🚧 Planned | Clock-in/clock-out logger with daily totals, overtime flags and weekly summaries |

---

## Features

- **User profile:** enter a username and birthday at startup, with input validation (correct date format, no future birthdays). Both can be changed later from the main menu.
- **Save file management:** create, load, view and delete save files, including deleting the current file, a selected file or all files.
- **Password-protected saves:** passwords are hashed with **SHA-256** and are never stored as plain text.
- **JSON persistence:** data is saved as `.json` files using **Gson**, with a custom `TypeAdapter` for `LocalDate`.
- **Activity logging:** actions like logging in, logging out and adding subscriptions are recorded in a `.log` file for each save file.
- **Error handling:** clear error messages for invalid input, bad dates and file problems instead of crashes.

---

## Built With

- **Java 17+** (Date and Time API: `LocalDate`, `Period`, `ChronoUnit`)
- **[Gson](https://github.com/google/gson)** for JSON serialization
- `java.security.MessageDigest` for SHA-256 hashing

---

## Project Structure

```
ChronoSuite/
├── Menu.java                      # Entry point (main) + Main Menu
├── Applications/
│   ├── Application.java
│   ├── MileStoneTracker/          # Milestone logic, data class + menu
│   ├── SubscriptionTracker/       # Subscription logic, data classes + menu
│   └── WorkHoursTracker/          # Planned
└── Misc/
    ├── DataManager.java           # Age calculation and password hashing
    ├── FileManager.java           # Creating, loading and saving JSON files
    ├── Logger.java                # Activity logs
    ├── ReuseableMethodsCLI.java   # Shared input/output helpers
    └── GSON_Adapters/
        └── GsonAdapter_Date.java  # LocalDate ↔ JSON adapter
```

Save files and logs are created automatically at runtime in a `Saves/` folder:

```
Saves/
└── <AppName>/
    ├── Datas/   # .json save files
    └── Logs/    # .log activity files
```

---

## How to Run

### Requirements
- **JDK 17 or newer** (`java -version` to check)
- **Gson** (download the `.jar` from [Maven Central](https://central.sonatype.com/artifact/com.google.code.gson/gson) and place it in a `lib/` folder in the project root)

### Option 1: IDE (IntelliJ IDEA / VS Code)
1. Clone the repository and open the folder in your IDE.
2. Add the Gson `.jar` as a library (IntelliJ: **File → Project Structure → Libraries → + → Java**, then select the `.jar`).
3. Run `Menu.java`.

### Option 2: Command Line

Run these from the project root so the `Saves/` folder is created in the right place.

**Windows (PowerShell):**
```powershell
javac -encoding UTF-8 -cp "lib/*" -d out (Get-ChildItem -Recurse -Filter *.java).FullName
java -cp "out;lib/*" Menu
```

**macOS / Linux:**
```bash
javac -encoding UTF-8 -cp "lib/*" -d out $(find . -name "*.java")
java -cp "out:lib/*" Menu
```

**Windows tip:** if the menu borders show up as `?` or strange symbols, run `chcp 65001` first to switch the terminal to UTF-8.

---

## Roadmap

- [x] Migrate saves from Java serialization to JSON (Gson + custom `LocalDate` adapter)
- [x] Hash passwords with SHA-256
- [x] Subscription Tracker (console + JSON)
- [ ] Separate the app logic from console input/output
- [ ] Package as a standalone `.exe`
- [ ] Work Hours Tracker

---

## Author

**Christ Aerjil C. Dampog**, Computer Information Systems student at Finger Lakes Community College
GitHub: [@KirisutoK](https://github.com/KirisutoK)
