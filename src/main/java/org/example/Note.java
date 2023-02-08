package org.example;

import java.time.LocalDateTime;
import java.util.Date;

public class Note  {
    private int id;
    private String title;
    private String text;
    private Date date;

    public Note(int id, String title, String text, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }
}
