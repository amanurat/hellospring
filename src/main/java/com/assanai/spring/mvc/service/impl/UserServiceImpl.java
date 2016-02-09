package com.assanai.spring.mvc.service.impl;

import com.assanai.spring.mvc.exception.UserNotFoundException;
import com.assanai.spring.mvc.domain.User;
import com.assanai.spring.mvc.repository.hibernate.UserRepository;
import com.assanai.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional(readOnly = true)
    public User findUser(Integer id) throws UserNotFoundException {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException("User " + id + " could not found.");
        }
        return user;
    }


    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

//    @Transactional(transactionManager = "jpaTransactionManager")
    @Transactional
    public void create(User user) {
        userRepository.create(user);
    }

    @Transactional
    public void update(User user) {
        userRepository.update(user);
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }
    @Transactional
    public void delete(Integer id) {
        userRepository.delete(id);
    }

}
