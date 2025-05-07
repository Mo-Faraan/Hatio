package com.example.todolist.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.todolist.Model.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo,Integer> {
    @Query("SELECT t FROM Todo t WHERE t.completed = true")
    List<Todo> findAllByCompleted();

    @Query("SELECT t FROM Todo t order by t.completed ASC, t.deadline ASC")
    List<Todo> getAllTodos();
    
}
