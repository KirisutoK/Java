# MileStone Tracker — Next Phase Roadmap

**Goal:** Turn the current console app into a portfolio-ready desktop application recruiters will actually stop and look at, without building out the other stubbed features yet.

**Sequence:** JSON persistence → JavaFX GUI → round out one more feature → (optional) SQL / cloud later.

---

## Phase 0 — Before you start

- [ ] Create a new git branch or tag the current working version (`v1.0-console`) so you always have a working fallback to point to on your resume, even mid-refactor.
- [ ] Re-read your own code once through — you'll be touching `MileStoneTrackerData` and `MileStoneTracker` a lot in Phase 1, so it's worth having the current structure fresh in your head.

---

## Phase 1 — JSON Persistence

**Why this first:** it's self-contained, fixes a real compatibility bug you already have with old save files, and is the actual industry-standard way to persist structured data (way more common than Java's built-in serialization).

### Learning first
- [ ] Read up on **Gson** (simplest to start with) or **Jackson** (more powerful, more common in real jobs — worth learning eventually either way).
- [ ] Understand the difference between *serializing an object directly* (what you do now) vs. *mapping an object to/from a JSON structure* (what you're moving to).

### Implementation steps
- [ ] Add the Gson (or Jackson) dependency to your project.
- [ ] Design what your save file should look like as JSON — sketch it out by hand first (username, birthday, milestones, etc.) before writing code.
- [ ] Replace `ObjectOutputStream`/`ObjectInputStream` calls in `MileStoneTracker` with JSON read/write calls.
- [ ] Change your save file extension (e.g. `.AMST_Data` → `.json` or keep a custom extension but store JSON text inside it — your call).
- [ ] Decide what to do with your existing `.AMST_Data` test files — you can just delete them and start fresh with the new format, no migration needed since there's no real user data yet.
- [ ] Test: create a file, add milestones, close the app, reopen, load the file — confirm nothing is lost.

### What "done" looks like
- [ ] You can open a save file in a plain text editor and read it.
- [ ] Old save files are gone; new ones are created and loaded correctly through the app.
- [ ] You could explain in an interview *why* you moved away from Java serialization (readability, debuggability, portability, avoiding the deserialization security concerns).

---

## Phase 2 — JavaFX GUI

**Why this next:** this is the single biggest visual jump for anyone opening your `.jar`/`.exe` — especially since you're targeting non-technical users. A terminal window is a hard sell no matter how clean the box-drawing menus are.

### Learning first
- [ ] Go through a basic JavaFX tutorial (Scene Builder + FXML, or plain Java UI code — either is fine to start).
- [ ] Get comfortable with the core building blocks: `Stage`, `Scene`, layouts (`VBox`/`GridPane`/`BorderPane`), buttons, text fields, event handlers.

### Implementation steps
- [ ] Sketch (even on paper) what the main screen should look like — profile info, milestone list, add/delete buttons.
- [ ] Keep your existing `MileStoneTracker` / `MileStoneTrackerData` classes as your **logic layer** — don't rewrite the logic, just build a UI that calls into it. This is a good habit: separating logic from UI.
- [ ] Build screens incrementally: start with just "view your milestones" working end-to-end before adding create/delete/edit.
- [ ] Wire up your JSON save/load from Phase 1 to buttons instead of console prompts.
- [ ] Add basic styling (even simple CSS via JavaFX) — doesn't need to be fancy, just intentional.

### What "done" looks like
- [ ] The full milestone-tracking flow (create profile → add milestones → save → reload) works entirely through the GUI, no terminal interaction needed.
- [ ] You can package it as a runnable `.jar`/`.exe` that a non-technical person could double-click and use.

---

## Phase 3 — Round out one more feature

**Why this matters:** proves the JSON + JavaFX pattern wasn't a one-off fluke, and shows you can apply the same architecture twice.

- [ ] Pick one stub (`DayPlanner` or `SubscriptionTracker` are probably the most natural fits).
- [ ] Build it using the same pattern: data class → logic class → JSON persistence → JavaFX screen.
- [ ] Bonus: if both features can share the same user profile/data file, this is a natural point to *start* thinking about whether a real embedded database (SQLite) would simplify things — but that's a Phase 4 decision, not required here.

---

## Phase 4 (optional, later) — SQL or Cloud

Only worth doing once Phases 1–3 are solid and you want to keep going:

- [ ] **SQLite via JDBC** — makes sense once you have multiple features sharing relational data (e.g. one user, many milestones, many subscriptions).
- [ ] **Serverless/cloud backend** (Firebase, Supabase, etc.) — a bigger architectural leap (auth, network access, API keys). Treat this as a "v3.0" idea if you ever want cross-device access to your data, not a required next step.

---

## Wrap-up checklist before you go back to your lessons

- [ ] README updated: what it does, screenshots of the JavaFX UI, how to run it.
- [ ] `.jar`/`.exe` built and tested on a clean machine (or at least a clean test run) to make sure a non-technical user could actually run it.
- [ ] Old test save files and stray "WIP" labels cleaned up or clearly marked as future work.
- [ ] Push to GitHub with a clear commit history — recruiters sometimes skim commit messages too, so it's worth writing them like you're narrating the journey (e.g. "migrate persistence from Java serialization to JSON", "add JavaFX main screen").

---

*No rush on any of this — you started this whole project a week ago and already have a genuinely solid console app with real bug fixes behind it. This roadmap is meant to be worked through at whatever pace fits around your coursework.*