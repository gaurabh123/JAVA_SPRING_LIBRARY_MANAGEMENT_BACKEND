package com.lsp.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookUpdateDTO {

    private int bookId;

    private String title;

    private int  authorId;

    private int publisherId;
}
