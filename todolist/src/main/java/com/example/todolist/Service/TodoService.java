package com.example.todolist.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.Model.Todo;
import com.example.todolist.Repo.TodoRepo;

@Service
public class TodoService {

    @Autowired
    private TodoRepo repo;

    
    public List<Todo> getAllTodos(){
        return repo.getAllTodos();
    }


    public Todo createTodo(Todo todo) throws Exception {
        if (todo.getDeadline() == null) {
            throw new Exception("Deadline cant be null.");
        }
        else
            return repo.save(todo);
    }

    public Todo updateTodo(Todo todo) throws Exception {

        if (todo.getDeadline() == null) {
            throw new Exception("Deadline cant be null.");
        }
        else
            return repo.save(todo);
    }


    public Todo updateComplete(Todo todo) {
        if(todo.getCompleted()==false){
            todo.setCompleted(true);
        }
        else{
            todo.setCompleted(false);
        }
        repo.save(todo);
        return todo;
    }

    public Optional<Todo> getTodoById(int id) {
        Optional<Todo> todo = repo.findById(id);
        return todo;
    }

    public void deleteTodo(int id) {
        repo.deleteById(id);

    }


    public List<Todo> getCompletedTodos() {
        List<Todo> response = repo.findAllByCompleted();
        return response;
    }
    

}
