/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo.Controller;
import com.example.todo.Models.Motivo;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.todo.Models.Tarea;
import com.example.todo.Models.Usuario;
import com.example.todo.exception.ResourceNotFoundException;
import com.example.todo.Repository.*;
import com.example.todo.clases.TareaMotivo;
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
    @Autowired
    private MotivoRepository motivoRepository;
    @Autowired
    private UserRepository userRepository;

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
    public Tarea createTodo(@Valid @RequestBody TareaMotivo tarea) {
        Tarea t = tarea.getTarea();
        String nombreMotivo = tarea.getNombreMotivo();
        Motivo m = motivoRepository.findByNombre(nombreMotivo);
        t.setId_motivo(m);
        return tareaRepository.save(t);
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
    
    @PostMapping("/motivo-create")
    public Motivo guardar(@Valid @RequestBody Motivo motivo) {
        return motivoRepository.save(motivo);
    }
    
    @GetMapping("/motivos")
    public List<Motivo> getMotivos(){
        return motivoRepository.findAll();
    }
    
    @GetMapping("/motivo-id//{nombre}")
    public ResponseEntity<Motivo>obtenerMotivo(@PathVariable(value = "nombre") String nombre){
       Motivo motivo = motivoRepository.findByNombre(nombre);
       return ResponseEntity.ok().body(motivo);
    }
    
    @PostMapping("/create-user")
    public Usuario createUser(@Valid @RequestBody Usuario user){
        if(validarUsuario(user.getNombre())){
            return new Usuario("Ya existe este usuario");
        }
        return userRepository.save(user);
    }
    
    private boolean validarUsuario(String username) {
            Usuario user = userRepository.findByNombre(username);
                if (user != null) {
                    if (user.getNombre().equals(username)) {
                    return true;
                }
            }
        return false;
    }
}
