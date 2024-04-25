package com.jeiel.todo.Domains.Task;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity(name="tasks")
@Table(name="tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String description;
    private LocalDateTime date;
    private Duration duration;

    public Task(String title, String description, LocalDateTime date, Duration duration){
        this.title = title;
        this.description = description;
        this.date = date;
        this.duration = duration;
    }
}
