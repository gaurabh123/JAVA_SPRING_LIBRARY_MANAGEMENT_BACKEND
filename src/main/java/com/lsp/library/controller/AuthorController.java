package com.lsp.library.controller;

import com.lsp.library.dto.AuthorDTO;
import com.lsp.library.dto.AuthorSaveDTO;
import com.lsp.library.dto.AuthorUpdateDTO;
import com.lsp.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// one author has many books
@RestController
@CrossOrigin
@RequestMapping("api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/save")
    public String saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO) {
        String authorName = authorService.addAuthor(authorSaveDTO);
        return "Author Added Successfully";
    }

    @GetMapping(path="/getAllAuthor")
    public List<AuthorDTO> getAllAuthor() {
        List<AuthorDTO> allAuthors = authorService.getAllAuthor();
        return allAuthors;
    }

    @PutMapping(path="/update")
    public String updateAuthor(@RequestBody AuthorUpdateDTO authorUpdateDTO) {
        String authorName = authorService.updateAuthor(authorUpdateDTO);
        return authorName;
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteAuthor(@PathVariable(value = "id") int id) {
        String authorName = authorService.deleteAuthor(id);
        return "DELETED SUCCESSFULLY";
    }

}
