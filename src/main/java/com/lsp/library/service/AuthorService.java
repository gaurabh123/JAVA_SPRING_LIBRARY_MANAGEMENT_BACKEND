package com.lsp.library.service;


import com.lsp.library.dto.AuthorDTO;
import com.lsp.library.dto.AuthorSaveDTO;
import com.lsp.library.dto.AuthorUpdateDTO;

import java.util.List;


public interface AuthorService {

    String addAuthor(AuthorSaveDTO authorSaveDTO);

    List<AuthorDTO> getAllAuthor();

    String updateAuthor(AuthorUpdateDTO authorUpdateDTO);

    String deleteAuthor(int id);
}
