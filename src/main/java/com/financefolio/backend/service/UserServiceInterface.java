package com.financefolio.backend.service;

import com.financefolio.backend.dto.UserDTO;

import java.util.ArrayList;

public interface UserServiceInterface {

    ArrayList<UserDTO> getAllUsers();

    UserDTO getUser(String email);

    void addUser(UserDTO userDTO);

    void updateUser(String email, UserDTO userDTO);

    void deleteUser(String email);
}
