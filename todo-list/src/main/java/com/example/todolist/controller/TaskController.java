package com.example.todolist.controller;

import com.example.todolist.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("total", taskService.getTaskCount());
        model.addAttribute("completed", taskService.getCompletedTasks().size());
        model.addAttribute("remaining",
                taskService.getIncompleteTasks().size());

        return "index";
    }

    @PostMapping("/tasks")
    public String addTask(
            @RequestParam String title,
            @RequestParam String description) {

        taskService.addTask(title, description);

        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/complete")
    public String completeTask(@PathVariable int id) {

        taskService.completeTask(id);

        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/uncomplete")
    public String uncompleteTask(@PathVariable int id) {

        taskService.uncompleteTask(id);

        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable int id) {

        taskService.deleteTask(id);

        return "redirect:/";
    }
}