package com.example.Task311.service;

import com.example.Task311.model.User;
import com.example.Task311.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public List<User> findAll() {return userRepository.findAll();}
    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }
    @Override
    public void  deleteById(Long id){
        userRepository.deleteById(id);
    }
}
