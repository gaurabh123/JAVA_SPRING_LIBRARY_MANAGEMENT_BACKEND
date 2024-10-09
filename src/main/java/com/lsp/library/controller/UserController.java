package com.lsp.library.controller;

import com.lsp.library.dto.*;
import com.lsp.library.service.AuthorService;
import com.lsp.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserSaveDTO userSaveDTO) {
        String userName = userService.addUser(userSaveDTO);
        return "User Added Successfully";
    }

    @GetMapping(path="/getAllUser")
    public List<UserDTO> getAllUser() {
        List<UserDTO> allUsers = userService.getAllUser();
        return allUsers;
    }

    @PutMapping(path="/update")
    public String updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        String userName = userService.updateUser(userUpdateDTO);
        return userName;
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {
        String userName = userService.deleteUser(id);
        return "DELETED SUCCESSFULLY";
    }
}
