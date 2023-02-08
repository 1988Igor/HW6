package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class NoteManagerImpl implements NoteManager {
    private List<Note> notes;

    public NoteManagerImpl() {
        this.notes = new ArrayList<>();
    }

    @Override
    public void addNote(Note note) {
        notes.add(note);
    }

    @Override
    public void editNote(int id, Note updatedNote) {
        for (Note note : notes) {
            if (note.getId() == id) {
                note.setTitle(updatedNote.getTitle());
                note.setText(updatedNote.getText());
                break;
            }
        }
    }

    @Override
    public void deleteNote(int id) {
        notes.removeIf(note -> note.getId() == id);
    }

    @Override
    public Note getNote(int id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }

    @Override
    public List<Note> getAllNotes() {
        return notes;
    }
}
