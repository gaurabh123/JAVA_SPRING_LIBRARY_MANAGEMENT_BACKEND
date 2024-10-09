package com.lsp.library.service;

import com.lsp.library.dto.BookDTO;
import com.lsp.library.dto.BookSaveDTO;
import com.lsp.library.dto.BookUpdateDTO;

import java.util.List;

public interface BookService {
    String addBook(BookSaveDTO bookSaveDTO);

    List<BookDTO> getAllBook();

    String updateBook(BookUpdateDTO bookUpdateDTO);

    String deleteBook(int id);
}
