package com.lsp.library.dto;

import com.lsp.library.entity.Author;
import com.lsp.library.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {

    private int bookId;

    private String title;

    private Author author;

    private Publisher publisher;
}
