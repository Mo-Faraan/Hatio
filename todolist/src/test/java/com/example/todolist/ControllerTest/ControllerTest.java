package com.example.todolist.ControllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.todolist.Controller.TodoController;
import com.example.todolist.Model.Todo;
import com.example.todolist.Service.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(TodoController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TodoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Todo todo;

    @BeforeEach
    public void setup() {
        todo = new Todo(1, "Title", "Description", LocalDate.of(2025, 10, 6), true);
    }

    
    @Test
    public void testGetAllTodos() throws Exception {
        when(service.getAllTodos()).thenReturn(List.of(todo));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1));
    }

    
    @Test
    public void testGetCompletedTodos() throws Exception {
        when(service.getCompletedTodos()).thenReturn(List.of(todo));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/todos/completed"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1));
    }

    @Test
    public void testGetTodoById_Found() throws Exception {
        when(service.getTodoById(1)).thenReturn(Optional.of(todo));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(todo.getId()))
                .andExpect(jsonPath("$.title").value(todo.getTitle()));
    }

   
    @Test
    public void testGetTodoById_NotFound() throws Exception {
        when(service.getTodoById(99)).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateTodo() throws Exception {
        when(service.createTodo(any(Todo.class))).thenReturn(todo);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.id").value(todo.getId()))
                .andExpect(jsonPath("$.title").value(todo.getTitle()));
    }

    @Test
    public void testCreateTodo_EmptyTitle() throws Exception {
        todo.setTitle("");  
    
        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateTodo_InvalidPastDeadline() throws Exception {
        todo.setDeadline(LocalDate.now().minusDays(1)); // set to yesterday

        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateTodo_ValidDeadlineToday() throws Exception {
        todo.setDeadline(LocalDate.now()); // valid (today)
    
        when(service.createTodo(todo)).thenReturn(todo);
    
        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isAccepted());
    }

    @Test
    public void testCreateTodo_ValidFutureDeadline() throws Exception {
        todo.setDeadline(LocalDate.now().plusDays(3)); // valid (future)
    
        when(service.createTodo(todo)).thenReturn(todo);
    
        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isAccepted());
    }
    

    @Test
    public void testUpdateTodo() throws Exception {
        when(service.updateTodo(any(Todo.class))).thenReturn(todo);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/todo/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.id").value(todo.getId()))
                .andExpect(jsonPath("$.title").value(todo.getTitle()));
    }

    @Test
    public void testUpdateTodo_InvalidData() throws Exception {
        todo.setTitle("");
    
        mockMvc.perform(MockMvcRequestBuilders.put("/api/todo/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUpdateTodo_InvalidPastDeadline() throws Exception {
        todo.setDeadline(LocalDate.now().minusDays(2));
    
        mockMvc.perform(MockMvcRequestBuilders.put("/api/todo/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isBadRequest());
    }
    
    
    @Test
    public void testUpdateComplete() throws Exception {
        when(service.updateComplete(any(Todo.class))).thenReturn(todo);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/todo/{id}/complete", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.completed").value(true));
    }

    
    @Test
    public void testDeleteTodo() throws Exception {
        when(service.getTodoById(1)).thenReturn(Optional.of(todo));
        doNothing().when(service).deleteTodo(1);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/todo/{id}", 1))
                .andExpect(status().isOk());
    }

}
