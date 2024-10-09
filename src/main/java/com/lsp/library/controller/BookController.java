package com.lsp.library.controller;

import com.lsp.library.dto.*;
import com.lsp.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(path = "/save")
    public String saveBook(@RequestBody BookSaveDTO bookSaveDTO) {
        String title = bookService.addBook(bookSaveDTO);
        return "Publisher Added Successfully";
    }

    @GetMapping(path="/getAllBook")
    public List<BookDTO> getAllBook() {
        List<BookDTO> allBooks = bookService.getAllBook();
        return allBooks;
    }

    @PutMapping(path="/update")
    public String updateBook(@RequestBody BookUpdateDTO bookUpdateDTO) {
        String bookName = bookService.updateBook(bookUpdateDTO);
        return bookName;
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {
        String bookName = bookService.deleteBook(id);
        return "DELETED SUCCESSFULLY";
    }
}
