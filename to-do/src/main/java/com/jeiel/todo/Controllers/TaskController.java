package com.jeiel.todo.Controllers;


import com.jeiel.todo.Domains.Task.Task;
import com.jeiel.todo.Repositories.TaskRepository;
import com.jeiel.todo.Repositories.TaskRequestDTO;
import com.jeiel.todo.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<String> addTask(@RequestBody TaskRequestDTO task){
        return taskService.addTask(task);
    }

    @PutMapping("/edit/{taskId}")
    public ResponseEntity<String> editTask(@PathVariable String taskId, @RequestBody TaskRequestDTO task){
        return taskService.editTask(taskId, task);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable String taskId){
        return taskService.deleteTask(taskId);
    }

    @GetMapping("/find/{title}")
    public List<Task> findTaskByTitle(@PathVariable String title){
        return taskService.findTaskByTitle(title);
    }

    @GetMapping("/find/all")
    public List<Task> findAll(){
        return taskService.findAllTasks();
    }
}
