package com.lsp.library.service;

import com.lsp.library.dto.UserDTO;
import com.lsp.library.dto.UserSaveDTO;
import com.lsp.library.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUser();

    String updateUser(UserUpdateDTO userUpdateDTO);

    String deleteUser(int id);
}
