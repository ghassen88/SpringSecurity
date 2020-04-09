package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long>{

}
