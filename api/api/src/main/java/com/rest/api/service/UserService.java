package com.rest.api.service;

import com.rest.api.entities.Users;
import com.rest.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users findById(Long id){
        return userRepository.findById(id).get();
    }
    public List<Users> findAll(){
        return userRepository.findAll();
    }

    public Users save(Users user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

}
