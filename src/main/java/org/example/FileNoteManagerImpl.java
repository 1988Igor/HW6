package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileNoteManagerImpl implements NoteManager {
    private List<Note> notes = new ArrayList<>();
    private final String FILE_NAME = "notes.txt";

    @Override
    public void addNote(Note note) {
        notes.add(note);
        saveNotesToFile();
    }

    @Override
    public void editNote(int id, Note updatedNote) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id) {
                notes.set(i, updatedNote);
                saveNotesToFile();
                break;
            }
        }
    }

    @Override
    public void deleteNote(int id) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id) {
                notes.remove(i);
                saveNotesToFile();
                break;
            }
        }
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

    private void saveNotesToFile() {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            for (Note note : notes) {
                fileWriter.write(note.getId() + "," + note.getTitle() + "," + note.getText() + "," + note.getDate() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNotesFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String title = values[1];
                String text = values[2];
                LocalDateTime date = LocalDateTime.parse(values[3]);
                notes.add(new Note(id, title, text, date));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
