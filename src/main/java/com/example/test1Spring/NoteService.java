package com.example.test1Spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class NoteService {
    private List<Note> listNote;

    public NoteService() {
        listNote = new ArrayList<>();
    }

    List<Note> listAll() {
        return listNote;
    }

    Note add(Note note) throws ArgumentException {
        if (note == null) {
            throw new ArgumentException("Note is incorrect");
        }
        if (note.getTitle() == null || note.getTitle().equals("")) {
            throw new ArgumentException("title of note is incorrect");
        }
        Random rnd = new Random(1L);
        long currentNoteId = rnd.nextLong();
        if (listNote.size() == 0) {
            note.setId(currentNoteId);
        } else {
            for (int i = 0; i < listNote.size(); i++) {
                if (listNote.get(i).getId() == currentNoteId) {
                    currentNoteId = rnd.nextLong();
                    i = 0;
                }
            }
            note.setId(currentNoteId);
        }
        listNote.add(note);
        return note;
    }

    void deleteById(long id) throws ArgumentException {
        for (Note note : listNote) {
            if (note.getId() == id) {
                listNote.remove(note);
                return;
            }
        }
        throw new ArgumentException("Id is not exist");
    }

    void update(Note note) throws ArgumentException {
        checkNote(note);
        for (Note currentNote : listNote) {
            if (currentNote.getId() == note.getId()) {
                currentNote.setContent(note.getContent());
                currentNote.setTitle(note.getTitle());
                return;
            }
        }
        throw new ArgumentException("Note is not exist");
    }

    Note getById(long id) throws ArgumentException {
        for (Note note : listNote) {
            if (note.getId() == id) {
                return note;
            }
        }
        throw new ArgumentException("id is not exist");
    }


    private void checkNote(Note note) throws ArgumentException {
        if (note == null) {
            throw new ArgumentException("Note is incorrect");
        }
        if (note.getId() == 0) {
            throw new ArgumentException("Note is incorrect");
        }
    }
}
