// Creation Date: July 22, 2026. at 7:13 PM
// Last Modified: July 22, 2026. at  7:29 PM

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        NoteKeeper keeper = new NoteKeeper("notes.txt");

        keeper.addNote("Buy groceries");
        keeper.addNote("Call the doctor");
        keeper.addNote("Finish Java homework");

        keeper.displayNotes();

        keeper.deleteNote("notes.txt"); // ... <========================= THIS IS A BUG STATED BY CLAUDE BUT PERSONALLY ITS JUST A USER ERROR DUE TO IT BEING THE USER WHO DID NOT PUT THE PROPER NAMING AND DATA.

        keeper.saveNote("Meeting at 3pm");

        keeper.displayNotes();

        System.out.println("File exists: " + keeper.fileExists());
    }

    // =========================== OTHER METHODS =========================== \\
}
