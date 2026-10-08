package com.example.todolist.service;

import com.example.todolist.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    private int nextId = 1;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(int id) {

        for (Task task : tasks) {

            if (task.getId() == id) {
                return task;
            }

        }

        return null;
    }

    public Task addTask(String title, String description) {

        Task task = new Task(
                nextId++,
                title,
                description
        );

        tasks.add(task);

        return task;
    }

    public boolean deleteTask(int id) {

        Task task = getTaskById(id);

        if (task == null) {
            return false;
        }

        tasks.remove(task);

        return true;
    }

    public boolean completeTask(int id) {

        Task task = getTaskById(id);

        if (task == null) {
            return false;
        }

        task.setCompleted(true);

        return true;
    }

    public boolean uncompleteTask(int id) {

        Task task = getTaskById(id);

        if (task == null) {
            return false;
        }

        task.setCompleted(false);

        return true;
    }

    public boolean updateTask(
            int id,
            String title,
            String description) {

        Task task = getTaskById(id);

        if (task == null) {
            return false;
        }

        task.setTitle(title);
        task.setDescription(description);

        return true;
    }

    public List<Task> getCompletedTasks() {

        List<Task> completedTasks = new ArrayList<>();

        for (Task task : tasks) {

            if (task.isCompleted()) {
                completedTasks.add(task);
            }

        }

        return completedTasks;
    }

    public List<Task> getIncompleteTasks() {

        List<Task> incompleteTasks = new ArrayList<>();

        for (Task task : tasks) {

            if (!task.isCompleted()) {
                incompleteTasks.add(task);
            }

        }

        return incompleteTasks;
    }

    public int getTaskCount() {
        return tasks.size();
    }
    
    public TaskService() {

    addTask(
            "Complete Java assignment",
            "Finish the Spring Boot development assignment."
    );

    addTask(
            "Write README",
            "Document the project and development process."
    );
}
    
}