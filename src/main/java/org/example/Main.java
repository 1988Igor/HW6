package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NoteManager noteManager = new FileNoteManagerImpl();
        NoteManagerImpl noteManager1 = new NoteManagerImpl();
        NotesViewer notesViewer = new NotesViewer();
        notesViewer.run();

    }
}








