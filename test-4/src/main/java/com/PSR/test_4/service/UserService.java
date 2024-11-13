package com.PSR.test_4.service;

import com.PSR.test_4.datatranceobject.UserDTO;
import com.PSR.test_4.model.User;
import com.PSR.test_4.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getUsers() {
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>() {}.getType());
    }

    public UserDTO saveuser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public UserDTO updateuser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public String deleteuser(UserDTO userDTO) {
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return "User deleted";
    }
}
