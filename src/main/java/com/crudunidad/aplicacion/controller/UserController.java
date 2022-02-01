package com.crudunidad.aplicacion.controller;

import com.crudunidad.aplicacion.entity.User;
import com.crudunidad.aplicacion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    //Nuevo Usuario
    @PostMapping("/user")
    public ResponseEntity<?> create (@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    //busqueda personalizada
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value="id") Long userId){
        Optional<User> optionalUser=userService.findById(userId);
        if(!optionalUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalUser);
    }
    //Modificar Usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody User userDatails,@PathVariable(value = "id") Long userId){
        Optional<User> user =userService.findById(userId);
        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }
        user.get().setNombre(userDatails.getNombre());
        user.get().setClave(userDatails.getClave());
        user.get().setEmail(userDatails.getEmail());
        user.get().setEstado(userDatails.getEstado());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
    }
    //eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId){
        if(!userService.findById(userId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }
    //Listar todos los usuarios
    @GetMapping
    public List<User> readAll(){
        List<User> users= StreamSupport.stream(userService.findAll().spliterator(),false).collect(Collectors.toList());
        return users;
    }

}
