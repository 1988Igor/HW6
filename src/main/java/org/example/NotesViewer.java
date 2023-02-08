package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NotesViewer {
    private static NoteManager noteManager = new FileNoteManagerImpl();

    private static Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Add note");
            System.out.println("2. Edit note");
            System.out.println("3. Delete note");
            System.out.println("4. Get note by id");
            System.out.println("5. Get all notes");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    editNote();
                    break;
                case 3:
                    deleteNote();
                    break;
                case 4:
                    getNoteById();
                    break;
                case 5:
                    getAllNotes();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;

            }
        }
    }

    private static void addNote() {
        Random random = new Random();
        int id = random.nextInt(1, 50);
        System.out.print("Enter note title: ");
        String title = scanner.nextLine();
        System.out.print("Enter note text: ");
        String text = scanner.nextLine();
        Note note = new Note(id, title, text, LocalDateTime.now());
        noteManager.addNote(note);
        System.out.println("Note added successfully.");
    }

    private static void editNote() {
        System.out.print("Enter note id to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Note note = noteManager.getNote(id);
        if (note == null) {
            System.out.println("Note not found.");
            return;
        }
        System.out.print("Enter updated title: ");
        String title = scanner.nextLine();
        System.out.print("Enter updated text: ");
        String text = scanner.nextLine();
        Note updatedNote = new Note(id, title, text, LocalDateTime.now());
        noteManager.editNote(id, updatedNote);
        System.out.println("Note updated successfully.");
    }

    private static void deleteNote() {
        System.out.print("Enter note id to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        noteManager.deleteNote(id);
        System.out.println("Note deleted successfully.");
    }

    private static void getNoteById() {
        System.out.print("Enter note id to obtain: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Note note = noteManager.getNote(id);
        if (note == null) {
            System.out.println("Note not found.");
            return;
        }
        System.out.println("Note:");
        System.out.println("Id: " + note.getId());
        System.out.println("Title: " + note.getTitle());
        System.out.println("Text: " + note.getText());
        System.out.println("Date: " + note.getDate());
    }

    private static void getAllNotes() {
        List<Note> notes = noteManager.getAllNotes();
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
            return;
        }
        System.out.println("Notes:");
        for (Note note : notes) {
            System.out.println("Id: " + note.getId());
            System.out.println("Title: " + note.getTitle());
            System.out.println("Text: " + note.getText());
            System.out.println("Date: " + note.getDate());
            System.out.println();
        }

    }
}
