// Creation Date: July 22, 2026. at 7:13 PM
// Last Modified: July 22, 2026. at  7:21 PM

import java.io.*;
import java.util.ArrayList;

public class NoteKeeper {
    private ArrayList<String> notes;
    private String filename;

    public NoteKeeper(String filename) {
        this.notes = new ArrayList<>();
        this.filename = filename;
        loadNotes();
    }

    public void addNote(String note) {
        notes.add(note);
        System.out.println("Note added: " + note);
    }

    public void deleteNote(String note) {
        if (notes.contains(note)) {
            notes.remove(note);
            System.out.println("Note deleted: " + note);
        } else {
            System.out.println("Note not found: " + note);
        }
    }

    public void saveNote(String note) {
        notes.add(note);
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (String n : notes) {
                pw.println(n);
            }
            System.out.println("Notes saved!");
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    public void loadNotes() {
        File file = new File(filename);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                notes.add(line);
            }
            System.out.println("Notes loaded!");
        } catch (IOException e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }

    public void displayNotes() {
        System.out.println("=== Notes ===");
        if (notes.isEmpty()) {
            System.out.println("No notes yet!");
            return;
        }
        for (int i = 0; i < notes.size(); i++) { //... <============================ FIXED (CHANGED THE COMPARISON SYMBOL | CHANGED THE STARTING POINT INTO 0 AND INCREMENTATION)
            System.out.println(i+1 + ". " + notes.get(i));
        }
    }

    public boolean fileExists() {
        return new File(filename).exists();
    }
}
