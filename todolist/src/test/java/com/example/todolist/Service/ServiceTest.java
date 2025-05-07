package com.example.todolist.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.todolist.Model.Todo;
import com.example.todolist.Repo.TodoRepo;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private TodoRepo repo;

    @InjectMocks
    private TodoService service;

    private Todo todo;

    @BeforeEach
    public void setup() {
        todo = new Todo(1, "Title", "Description", LocalDate.of(2025, 10, 5), true);
    }

   
    @Test
    public void testGetAllTodos() {
        when(repo.getAllTodos()).thenReturn(List.of(todo));

        List<Todo> response = service.getAllTodos();

        assertEquals(1, response.size());
        assertEquals(todo, response.get(0));
    }

   
    @Test
    public void testCreateTodo() throws Exception {
        when(repo.save(any(Todo.class))).thenReturn(todo);

        Todo response = service.createTodo(todo);

        assertNotNull(response);
        assertEquals(todo, response);
    }

    
    @Test
    public void testCreateTodo_NullDeadline() {
        Todo invalidTodo = new Todo(2, "Title", "Desc", null, false);

        Exception exception = assertThrows(Exception.class, () -> {
            service.createTodo(invalidTodo);
        });

        assertEquals("Deadline cant be null.", exception.getMessage());
        verify(repo, never()).save(any());
    }
    

    
    @Test
    public void testUpdateTodo() throws Exception {
        when(repo.save(any(Todo.class))).thenReturn(todo);

        Todo response = service.updateTodo(todo);

        assertNotNull(response);
        assertEquals(todo, response);
    }

    
    @Test
    public void testUpdateTodo_NullDeadline() {
        todo.setDeadline(null);

        Exception exception = assertThrows(Exception.class, () -> {
            service.updateTodo(todo);
        });

        assertEquals("Deadline cant be null.", exception.getMessage());
        verify(repo, never()).save(any());
    }

   
    @Test
    public void testUpdateComplete() {
        todo.setCompleted(false);

        when(repo.save(any(Todo.class))).thenReturn(todo);

        Todo response = service.updateComplete(todo);

        assertTrue(response.getCompleted());
    }

    
    @Test
    public void testDeleteTodo() {
        doNothing().when(repo).deleteById(1);

        service.deleteTodo(1);

        verify(repo, times(1)).deleteById(1);
    }

   
    @Test
    public void testGetCompletedTodos() {
        Todo todo1 = new Todo(1, "Title 1", "Desc 1", LocalDate.now(), true);
        Todo todo2 = new Todo(2, "Title 2", "Desc 2", LocalDate.now(), true);
        List<Todo> completedTodos = List.of(todo1, todo2);

        when(repo.findAllByCompleted()).thenReturn(completedTodos);

        List<Todo> response = service.getCompletedTodos();

        assertEquals(2, response.size());
        assertTrue(response.stream().allMatch(Todo::getCompleted));
    }

    
    @Test
    public void testGetTodoById_Found() {
        when(repo.findById(1)).thenReturn(Optional.of(todo));

        Optional<Todo> response = service.getTodoById(1);

        assertTrue(response.isPresent());
        assertEquals(todo, response.get());
    }

    
    @Test
    public void testGetTodoById_NotFound() {
        when(repo.findById(99)).thenReturn(Optional.empty());

        Optional<Todo> response = service.getTodoById(99);

        assertFalse(response.isPresent());
    }
}
