package com.rest.api.controller;

import com.rest.api.entities.Users;
import com.rest.api.error.ErrorResponse;
import com.rest.api.service.UserService;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController(value = "/api")
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private ErrorResponse errorResponse;

    @GetMapping(value = "/users",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping(value = "/users",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody Users user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @DeleteMapping(value = "/users/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity update(@PathVariable Long id, Users user) {
        try{
            Users userToUpdate = userService.findById(id);
            Optional<Users> checkUser = Optional.ofNullable(userToUpdate);
            if(checkUser.isPresent()){
                userToUpdate.setName(user.getName());
                userToUpdate.setLastname(user.getLastname());
                userService.save(userToUpdate);
                return ResponseEntity.ok(userToUpdate);
            }
        }catch(Exception e){
            errorResponse.setResponse("error");
            errorResponse.setErrorMessage("ID not found : " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
        return null;
    }

    @PatchMapping(value = "/users/{id}/{name}")
    public ResponseEntity updateName(@PathVariable Long id, @PathVariable String name ) {
        try{
            Users usertoPatch = userService.findById(id);
            usertoPatch.setName(name);
            userService.save(usertoPatch);
            return ResponseEntity.ok(usertoPatch);
        } catch (Exception e){
            errorResponse.setResponse("error");
            errorResponse.setErrorMessage("User not found : " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

    }

}
