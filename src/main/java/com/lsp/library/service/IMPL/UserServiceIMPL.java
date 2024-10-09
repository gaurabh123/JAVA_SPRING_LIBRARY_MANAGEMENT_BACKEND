package com.lsp.library.service.IMPL;

import com.lsp.library.dto.UserDTO;
import com.lsp.library.dto.UserSaveDTO;
import com.lsp.library.dto.UserUpdateDTO;
import com.lsp.library.entity.User;
import com.lsp.library.repo.UserRepo;
import com.lsp.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public String addUser(UserSaveDTO userSaveDTO) {
        User user = new User(
                userSaveDTO.getName(),
                userSaveDTO.getEmail()
        );
        userRepo.save(user);
        System.out.println("User Saved Successfully");
        return user.getName();
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> getUsers = userRepo.findAll(); // find all data from the entity.
        List<UserDTO> userDTOList = new ArrayList<>(); // DTOList, convert entity format to DTO form.

        for (User user : getUsers) { // get  Authors from all the authors
            UserDTO userDTO = new UserDTO( // convert it to DTO format.
                    user.getUserId(),
                    user.getName(),
                    user.getEmail()
            );
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public String updateUser(UserUpdateDTO userUpdateDTO) {
        if(userRepo.existsById(userUpdateDTO.getUserId())) {
            User user = userRepo.getById(userUpdateDTO.getUserId());
            user.setName(userUpdateDTO.getName());
            user.setEmail(userUpdateDTO.getEmail());
            userRepo.save(user);
            return user.getName();
        } else {
            System.out.println("User Does Not Exist: ");
        }
        return null;
    }

    @Override
    public String deleteUser(int id) {
        if(userRepo.existsById(id)) {
            userRepo.deleteById(id);

        } else {
            System.out.println("User Does Not Exist: ");
        }
        return null;
    }
}
