# MileStone Tracker (+ future features) — Roadmap

**Goal:** Turn the current console app into a portfolio-ready desktop application recruiters will actually stop and look at.

**Current sequence:** ~~JSON persistence~~ ✅ → New feature (console + JSON) → Decouple logic from I/O → JavaFX GUI → CLI/JavaFX launcher → package as `.exe` → (optional, later) SQL / cloud / Spring Boot website version.

---

## Phase 1 — JSON Persistence ✅ DONE

- [x] Added Gson, registered a custom `LocalDate` `TypeAdapter` (`GsonAdapter_Date`).
- [x] Replaced Java serialization with `updateJsonFile()` (Gson + `FileWriter`) for save, `Files.readString` + `gson.fromJson(...)` for load.
- [x] Switched save file extension to `.json` across create/load/delete.
- [x] Bonus, not originally planned: added password hashing (`SHA-256`) — resolved the old plaintext-password TODO along the way.
- [x] Found and fixed real bugs surfaced during the migration: `setUserBirthday()` parameter-shadowing bug, stale `.AMST_Data` extension left in `deleteSelectedFile()`, silent empty catch block on load failure.
- [x] Old serialized test save files retired along with the format switch.

**What you can already say about this in an interview:** migrated from Java serialization to JSON, wrote a custom Gson `TypeAdapter` for `LocalDate`, and used the migration as an opportunity to add password hashing and fix latent bugs.

---

## Phase 2 — Build One More Feature (console + JSON, same pattern as MileStoneTracker)

**Why now, before JavaFX:** proves the data-class → logic-class → JSON pattern generalizes before you add UI complexity on top. You'll also get a second concrete feature to build the JavaFX layer against in Phase 4, instead of just one.

- [ ] Pick one stub (`DayPlanner` or `SubscriptionTracker` are the most natural next picks).
- [ ] Build it the same shape as `MileStoneTracker`/`MileStoneTrackerData`: a data class (`Serializable`-free now, just plain fields), a logic class with create/load/delete file management, JSON persistence via the existing shared `ReuseableMethods.gson`.
- [ ] Wire it into the main menu the same way `MileStoneTracker` is wired in.
- [ ] Test the full loop: create → add data → save → close → reopen → load.

### What "done" looks like
- [ ] Two features fully working end-to-end on the console, both persisting through JSON.
- [ ] You've confirmed the pattern (data class / logic class / JSON) is genuinely reusable, not a one-off.

---

## Phase 3 — Decouple Logic from I/O

**Why this is its own phase:** this is the prerequisite for everything JavaFX- and launcher-related below. Right now your logic classes call `System.out.println(...)` and `ReuseableMethods.input.nextLine()` directly — that only works for a console. To support JavaFX (and eventually a CLI/JavaFX choice at startup), the logic layer needs to stop doing I/O itself.

- [ ] Go through `MileStoneTracker` (and the new feature from Phase 2) method by method: anywhere it prints or scans input directly, change it to instead return a value / result / thrown exception, and let the *caller* decide how to display it.
- [ ] Move all the `System.out.println` menu-drawing and `Scanner` prompts for each feature into a dedicated CLI-side class instead of living inside the logic class.
- [ ] Suggested structure to move toward:
  ```
  Classess/
  ├── MileStoneTracker/
  │   ├── MileStoneTracker.java       ← logic only, no I/O
  │   └── MileStoneTrackerData.java   ← already logic-only
  ├── DayPlanner/  (or whichever feature you picked)
  │   ├── DayPlanner.java
  │   └── DayPlannerData.java
  UI/
  ├── CLI/
  │   ├── Menu.java                   ← current console main menu, moved here
  │   └── MileStoneTrackerCLI.java    ← console prompts/printing, calls into Classess/ logic
  ```
- [ ] Re-test the CLI thoroughly after the refactor — this is a pure restructuring pass, behavior shouldn't change, so any difference you notice is a regression to fix.

### What "done" looks like
- [ ] Logic classes have zero `System.out`/`Scanner` calls.
- [ ] The CLI still works exactly as before, just calling into the logic layer instead of containing it.

---

## Phase 4 — JavaFX GUI

**Why this next:** biggest visual jump for anyone opening your `.jar`/`.exe`, and directly supports the non-technical-user distribution goal — a terminal window is a hard sell for that audience no matter how polished.

### Learning first
- [ ] Light refresher on FXML + Controller pattern specifically (you've used JavaFX before, so this is closing the specific gap, not a full relearn): an `.fxml` file describes layout, a Controller class (`@FXML`-annotated) handles events and talks to your logic classes.
- [ ] Get comfortable with a basic `SceneManager`/`ViewManager` pattern for swapping screens in and out of the primary `Stage`.

### Implementation steps
- [ ] Suggested structure:
  ```
  UI/
  ├── JavaFX/
  │   ├── MainApp.java                       ← extends Application, owns the primary Stage
  │   ├── SceneManager.java                  ← loads/swaps FXML screens
  │   ├── MileStoneTracker/
  │   │   ├── MileStoneTrackerController.java
  │   │   └── MileStoneTrackerView.fxml
  │   └── <SecondFeature>/
  │       ├── <SecondFeature>Controller.java
  │       └── <SecondFeature>View.fxml
  resources/
  └── UI/JavaFX/...                          ← .fxml/CSS files, mirroring the package structure (Maven-style, even without Maven yet)
  ```
- [ ] Build the `MileStoneTracker` screen first, incrementally: view-only first, then add/edit/delete.
- [ ] Wire buttons to your now-decoupled logic classes from Phase 3 — controllers should never print to console, only update UI components.
- [ ] Once the first feature's screen works end-to-end, build the second feature's screen — this should go faster since the pattern (and `SceneManager`) is already proven.
- [ ] Add basic styling (CSS via JavaFX) — doesn't need to be fancy, just intentional.

### What "done" looks like
- [ ] Both features fully usable through JavaFX, no terminal interaction needed.
- [ ] `SceneManager` cleanly switches between screens without duplicated boilerplate in each controller.

---

## Phase 5 — CLI / JavaFX Launcher

**Why this is its own phase, after both UIs exist:** the launcher only makes sense once there are genuinely two working interfaces to choose between.

- [ ] Create `Launcher.java` as the single real entry point (`public static void main`) for the whole application, replacing the current `Launcher.java`.
- [ ] At startup, ask the user: CLI or JavaFX.
    - CLI chosen → run `UI/CLI/Menu.java`'s loop, same as today.
    - JavaFX chosen → call `Application.launch(MainApp.class, args)`.
- [ ] Note: `MainApp` can keep its own `main()`/`launch(args)` too, purely as a convenience for testing JavaFX directly during development — but `Launcher.main()` is the one true entry point for the shipped product.
- [ ] (Optional, cosmetic) Add a visibly-disabled or "Coming soon" 3rd option for a future Spring Boot/website version — see Phase 7.

### What "done" looks like
- [ ] Running the program presents the CLI-vs-JavaFX choice before anything else loads.
- [ ] Both paths work correctly and independently.

---

## Phase 6 — Package as a Standalone `.exe`

- [ ] Bundle the project into a runnable `.jar` first (via your IDE's build/artifact tools).
- [ ] Use **`jpackage`** (built into the JDK, Java 14+) to wrap the `.jar` into a self-contained Windows `.exe` — bundles a Java runtime, so users don't need Java installed separately.
- [ ] Important JavaFX-specific detail: since JavaFX isn't part of the standard JDK, make sure the `jpackage` build explicitly includes the JavaFX runtime modules — it won't happen automatically just because JavaFX runs fine inside IntelliJ.
- [ ] Test the built `.exe` on a clean run (ideally a machine/VM without your dev setup) to simulate a non-technical user's experience.

### What "done" looks like
- [ ] A double-clickable `.exe` that launches straight into the CLI/JavaFX choice, no separate Java install required.

---

## Phase 7 (optional, later) — SQL or Spring Boot / Cloud

Only worth doing once Phases 1–6 are solid and you want to keep going:

- [ ] **SQLite via JDBC** — makes sense once multiple features share relational data (one user, many milestones, many day-plan entries, etc.).
- [ ] **Spring Boot (website version)** — treat this as a genuinely separate future project/deployment (a web version of the app), not a 3rd launch mode bundled into the same desktop `.exe`. Fundamentally different problem: a running server, a browser client, eventually hosting/networking — worth its own phase and its own README section once you get there.
- [ ] **Serverless/cloud backend** (Firebase, Supabase, etc.) — bigger architectural leap (auth, network access, API keys). A "v3.0" idea for cross-device access to your data, not a required next step.

---

## Wrap-up checklist before you go back to your lessons

- [ ] README updated: what it does, screenshots of the JavaFX UI, how to run it, and a "coming soon" note for the Spring Boot/web version if you want to signal future direction.
- [ ] `.exe` built and tested on a clean machine (or clean test run) to confirm a non-technical user could actually run it.
- [ ] Old test save files and stray "WIP" labels cleaned up or clearly marked as future work.
- [ ] Push to GitHub with a clear commit history — write commits like you're narrating the journey (e.g. "migrate persistence from Java serialization to JSON", "decouple logic layer from console I/O", "add JavaFX main screen").
- [ ] Decide on a project name/tagline for the README (e.g. something like *"Chronicle — a modular Java toolkit for tracking life milestones, schedules, and time across zones"*) so it reads as one cohesive platform rather than a single-feature app.

---

*No rush on any of this — you started this whole project a few weeks ago and already have a genuinely solid console app, a completed JSON migration, and real bug fixes behind it. Work through this at whatever pace fits around your coursework.*