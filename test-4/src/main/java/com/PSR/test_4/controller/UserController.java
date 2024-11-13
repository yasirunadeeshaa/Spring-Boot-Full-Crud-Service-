package com.PSR.test_4.controller;

import com.PSR.test_4.datatranceobject.UserDTO;
import com.PSR.test_4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="api/v1")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getuser")
    public List<UserDTO> getUser() {
        return userService.getUsers();
    }
    @PostMapping("/adduser")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.saveuser(userDTO);
    }
    @PutMapping("/updateuser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateuser(userDTO);
    }

    @DeleteMapping("/deleteuser")
    public String deleteUser(@RequestBody UserDTO userDTO) {
        return userService.deleteuser(userDTO);
    }
}
