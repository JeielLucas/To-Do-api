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
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody TaskRequestDTO task){
        return taskService.addTask(task);
    }

    @PutMapping("/edit/{taskId}")
    public ResponseEntity<Task> editTask(@PathVariable String taskId, @RequestBody TaskRequestDTO task){
        return taskService.editTask(taskId, task);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable String taskId){
        return taskService.deleteTask(taskId);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Task>> findTaskByTitle(@RequestParam(value = "title", defaultValue = "") String title){
        List<Task> taskList = taskService.findTaskByTitle(title);
        return ResponseEntity.ok().body(taskList);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Task>> findAll(){
        List<Task> taskList = taskService.findAllTasks();
        return ResponseEntity.ok().body(taskList);
    }
}
