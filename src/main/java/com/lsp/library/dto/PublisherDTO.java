package com.lsp.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//instead of getters and setters we use the lombok annotations.
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublisherDTO {

    private int publisherId;

    private String name;
}
