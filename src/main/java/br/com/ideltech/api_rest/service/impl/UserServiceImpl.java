package br.com.ideltech.api_rest.service.impl;

import br.com.ideltech.api_rest.domain.model.User;
import br.com.ideltech.api_rest.domain.repository.UserRepository;
import br.com.ideltech.api_rest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        //if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
        //    throw new IllegalArgumentException("This User ID already exists");
        //}

        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account Number already exists");
        }

        return userRepository.save(userToCreate);
    }
}
