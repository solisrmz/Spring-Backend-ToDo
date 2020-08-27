/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo.Controller;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.todo.Models.Tarea;
import com.example.todo.exception.ResourceNotFoundException;
import com.example.todo.Repository.TareaRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
/**
 *
 * @author José A Solís
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(("/api/v1"))
public class TareaController {
    @Autowired
    private TareaRepository tareaRepository;

    //Para obtener todas mis tareas
    @GetMapping("/todos")
    public List<Tarea> getAllTodo() {
        return tareaRepository.findAll();
    }
    
    //Acceder a los detalles de una tarea
    @GetMapping("/todos/{id}")
    public ResponseEntity<Tarea> getTodoById(@PathVariable(value = "id") Long tareaId)
        throws ResourceNotFoundException {
        Tarea employee = tareaRepository.findById(tareaId)
          .orElseThrow(() -> new ResourceNotFoundException("ToDo not found for this id :: " + tareaId));
        return ResponseEntity.ok().body(employee);
    }
    
    //Insertar una nueva tarea a la base de datos
    @PostMapping("/create-todo")
    public Tarea createTodo(@Valid @RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }
    
    //Para actualizar una tarea
    @PutMapping("/update-todo/{id}")
    public ResponseEntity<Tarea> updateTodo(@PathVariable(value = "id") Long tareaId,
        @Valid @RequestBody Tarea tareaDetails) throws ResourceNotFoundException {
        Tarea tarea = tareaRepository.findById(tareaId)
        .orElseThrow(() -> new ResourceNotFoundException("ToDo not found for this id :: " + tareaId));

        tarea.setName(tareaDetails.getName());
        tarea.setDescription(tareaDetails.getDescription());
        final Tarea updateTarea = tareaRepository.save(tarea);
        return ResponseEntity.ok(updateTarea);
    }
    
    //Para borrar una tarea
    @DeleteMapping("/delete-todo/{id}")
    public Map<String, Boolean> deleteTodo(@PathVariable(value = "id") Long tareaId)
         throws ResourceNotFoundException {
        Tarea tarea = tareaRepository.findById(tareaId)
       .orElseThrow(() -> new ResourceNotFoundException("ToDo not found for this id :: " + tareaId));

        tareaRepository.delete(tarea);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
