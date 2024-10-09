package com.lsp.library.service.IMPL;

import com.lsp.library.dto.AuthorDTO;
import com.lsp.library.dto.AuthorSaveDTO;
import com.lsp.library.dto.AuthorUpdateDTO;
import com.lsp.library.entity.Author;
import com.lsp.library.repo.AuthorRepo;
import com.lsp.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceIMPL implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public String addAuthor(AuthorSaveDTO authorSaveDTO) {
        Author author = new Author(
                authorSaveDTO.getName()
                );
        authorRepo.save(author);
        System.out.println("Author Saved Successfully");
        return author.getName();
    }

    @Override
    public List<AuthorDTO> getAllAuthor() {
        List<Author> getAuthors = authorRepo.findAll(); // find all data from the entity.
        List<AuthorDTO> authorDTOList = new ArrayList<>(); // DTOList, convert entity format to DTO form.

        for (Author author : getAuthors) { // get  Authors from all the authors
            AuthorDTO authorDTO = new AuthorDTO( // convert it to DTO format.
                    author.getAuthorId(),
                    author.getName()
            );
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }

    @Override
    public String updateAuthor(AuthorUpdateDTO authorUpdateDTO) {
        // check id exists or not.
        if(authorRepo.existsById(authorUpdateDTO.getAuthorId())) {
            Author author = authorRepo.getById(authorUpdateDTO.getAuthorId());
            author.setName(authorUpdateDTO.getName());
            authorRepo.save(author);
            return author.getName();
        } else {
            System.out.println("Author Does Not Exist: ");
        }
        return null;
    }

    @Override
    public String deleteAuthor(int id) {
        if(authorRepo.existsById(id)) {
            authorRepo.deleteById(id);

        } else {
            System.out.println("Author Does Not Exist: ");
        }
        return null;
    }
}
