package com.example.backendportafolio.Services;

import com.example.backendportafolio.Models.UserModel;
import com.example.backendportafolio.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(UserModel user) {
        userRepository.save(user);
    }

    public UserModel find(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean existsById(Long id){
        return userRepository.existsById(id);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

}
