package com.jeiel.todo.Repositories;

import com.jeiel.todo.Domains.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
