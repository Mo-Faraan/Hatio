package com.example.todolist.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.Model.Todo;
import com.example.todolist.Service.TodoService;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/api")
@CrossOrigin
public class TodoController {
    
    @Autowired
    private TodoService service;

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> response = service.getAllTodos();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    @PostMapping("/todo")
    public ResponseEntity<?> createTodo(@Valid @RequestBody Todo todo) {
        Todo response;
        try{
            response = service.createTodo(todo);
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable int id, @Valid @RequestBody Todo todo) {
        Todo response;
        try{
            response = service.updateTodo(todo);
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/todo/{id}/complete")
    public ResponseEntity<?> updateComplete(@PathVariable int id, @RequestBody Todo todo) {
        Todo response;
        try{
            response = service.updateComplete(todo);
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   
    
    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable int id){
        Optional<Todo> response = service.getTodoById(id);
        if (response.isPresent()){
            service.deleteTodo(id);
            return new ResponseEntity<>("Todo Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/todo/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable int id) {
        
        Optional<Todo> response = service.getTodoById(id);
        if (response.isPresent()){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    @GetMapping("/todos/completed")
    public ResponseEntity<?> getCompletedTodos() {
        List<Todo> response = service.getCompletedTodos();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
}
