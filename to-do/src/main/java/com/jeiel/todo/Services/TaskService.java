package com.jeiel.todo.Services;

import com.jeiel.todo.Domains.Task.Task;
import com.jeiel.todo.Repositories.TaskRepository;
import com.jeiel.todo.Repositories.TaskRequestDTO;
import com.jeiel.todo.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public ResponseEntity addTask(TaskRequestDTO taskRequestDTO){
        Task task = new Task(taskRequestDTO.title(),
                taskRequestDTO.description(),
                taskRequestDTO.date(),
                taskRequestDTO.duration());

        taskRepository.save(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    public ResponseEntity deleteTask(String id){
        Task taskForDelete = searchTask(id);

        taskRepository.delete(taskForDelete);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Task> editTask(String id, TaskRequestDTO task){
        Task taskForEdit = searchTask(id);

        if(task.title() != null) taskForEdit.setTitle(task.title());
        if(task.description() != null) taskForEdit.setDescription(task.description());
        if(task.date() != null) taskForEdit.setDate(task.date());
        if(task.duration() != null) taskForEdit.setDuration(task.duration());

        taskRepository.save(taskForEdit);

        return ResponseEntity.ok(taskForEdit);

    }

    public List<Task> findTaskByTitle(String title){
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    private Task searchTask(String id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task não encontrada com o id: " + id));
    }
}
