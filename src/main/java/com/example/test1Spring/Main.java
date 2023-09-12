package com.example.test1Spring;

public class Main {
    public static void main(String[] args) throws ArgumentException {
        NoteService noteService = new NoteService();
        System.out.println( noteService.listAll());
        Note note = new Note();
        note.setTitle("car wash1");
        note.setContent("taking cars to the car wash1");
        Note noteFomNoteService= noteService.add(note);
        System.out.println(noteFomNoteService);
        System.out.println(noteService.getById(noteFomNoteService.getId()));
        noteService.deleteById(noteFomNoteService.getId());

    }
}
