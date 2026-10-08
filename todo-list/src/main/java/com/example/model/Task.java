package com.example.todolist.model;

public class Task {

    private int id;
    private String title;
    private String description;
    private boolean completed;

    public Task() {
    }

    public Task(int id, String title, String description) {
        setTitle(title);
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Task title cannot be empty."
            );
        }

        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}