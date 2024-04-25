package com.jeiel.todo.Repositories;

import com.jeiel.todo.Domains.Task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findByTitleContainingIgnoreCase(String substring);
}
