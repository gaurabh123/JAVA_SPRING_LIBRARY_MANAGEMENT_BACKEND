package com.lsp.library.repo;


import com.lsp.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

// query management repo
public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
