package com.financefolio.backend.service.implementation;

import com.financefolio.backend.dto.UserDTO;
import com.financefolio.backend.exception.AlreadyExistException;
import com.financefolio.backend.exception.NotFoundException;
import com.financefolio.backend.model.User;
import com.financefolio.backend.repository.UserRepository;
import com.financefolio.backend.service.UserServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j(topic = "USER_SERVICE")
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUser(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new NotFoundException(String.format("User %s Not Found", email));
        }
        log.info(String.format("User %s is fetched successfully", email));
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), null);
    }

    @Override
    public void addUser(UserDTO userDTO){
        String email = userDTO.getEmail();
        User userExists = userRepository.findByEmail(email);
        if(userExists != null){
            throw new AlreadyExistException(String.format("User with email %s already exists", email));
        }
        User user = new User(userDTO);
        userRepository.save(user);
        log.info(String.format("User with email %s is added successfully", email));
    }
}
