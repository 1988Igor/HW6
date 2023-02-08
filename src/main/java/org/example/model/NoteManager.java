package org.example.model;

import java.util.List;

public interface NoteManager {
    void addNote(Note note);

    void editNote(int id, Note updatedNote);

    void deleteNote(int id);

    Note getNote(int id);

    List<Note> getAllNotes();
}
