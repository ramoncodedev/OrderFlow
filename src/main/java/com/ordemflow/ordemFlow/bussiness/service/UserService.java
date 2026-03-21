package com.ordemflow.ordemFlow.bussiness.service;

import com.ordemflow.ordemFlow.infrastructure.Entity.User;
import com.ordemflow.ordemFlow.infrastructure.exception.ResourceNotFoundException;
import com.ordemflow.ordemFlow.infrastructure.exception.conflictionException;
import com.ordemflow.ordemFlow.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User registerUser(User user){

        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);

        verifyEmail(user.getEmail());
        return userRepository.save(user);
    }

    public void verifyEmail(String email){
        if (existsEmail(email)){
            throw new conflictionException("This email address is not available.");
        }
    }

    public boolean existsEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public List<User> findAll(){
        List<User> users = userRepository.findAll();

        if (users.isEmpty()){
            throw new ResourceNotFoundException("There are no registered users.");
        }
        return users;
    }

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow( ()-> new ResourceNotFoundException("There are no registered users."));
    }

    public User update(Long id, User user){
        User newUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));

        if (newUser.getEmail().equals(user.getEmail())){
            verifyEmail(user.getEmail());
        }

        newUser.setName(user.getName());
        newUser.setAdress(user.getAdress());
        newUser.setPassword(user.getPassword());

        return newUser;
    }

    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found."));

        userRepository.deleteById(id);
    }

}
