package com.dev.knplab.knp.dbtestapp;

import android.support.annotation.Nullable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Table(name = "Tasks")
public class Task extends Model {
    @Column(name = "Title")
    String title;
    @Column(name = "Content")
    String content;
    @Nullable
    @Column(name = "Date")
    Date date;
    @Column(name = "Done")
    boolean done;

    public Task(){
        super();
    }

    public Task(String title, String content) {
        super();
        this.title = title;
        this.content = content;
        done = false;
        date = Calendar.getInstance(Locale.getDefault()).getTime();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return String.format("%s\r\n%s\r\n%s",title, content, date.toString());
    }
}
