package com.example.todolist;

import com.example.todolist.model.Task;
import com.example.todolist.service.TaskService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void shouldAddTask() {

        TaskService service = new TaskService();

        Task task = service.addTask(
                "Test task",
                "Test description"
        );

        assertNotNull(task);
        assertEquals(
                "Test task",
                task.getTitle()
        );
        assertEquals(3, service.getTaskCount());
    }

    @Test
    void shouldFindTaskById() {

        TaskService service = new TaskService();

        Task task = service.getTaskById(1);

        assertNotNull(task);
        assertEquals(1, task.getId());
    }

    @Test
    void shouldReturnNullForInvalidId() {

        TaskService service = new TaskService();

        assertNull(
                service.getTaskById(999)
        );
    }

    @Test
    void shouldCompleteTask() {

        TaskService service = new TaskService();

        assertTrue(
                service.completeTask(1)
        );

        assertTrue(
                service.getTaskById(1).isCompleted()
        );
    }

    @Test
    void shouldDeleteTask() {

        TaskService service = new TaskService();

        assertTrue(
                service.deleteTask(1)
        );

        assertNull(
                service.getTaskById(1)
        );
    }

    @Test
    void shouldUpdateTask() {

        TaskService service = new TaskService();

        assertTrue(
                service.updateTask(
                        1,
                        "Updated task",
                        "Updated description"
                )
        );

        assertEquals(
                "Updated task",
                service.getTaskById(1).getTitle()
        );
    }

    @Test
    void shouldGetCompletedTasks() {

        TaskService service = new TaskService();

        service.completeTask(1);

        List<Task> completed =
                service.getCompletedTasks();

        assertEquals(1, completed.size());
    }

    @Test
    void shouldRejectEmptyTaskTitle() {

        TaskService service = new TaskService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.addTask(
                        "",
                        "Description"
                )
        );
    }
}