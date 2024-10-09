package com.lsp.library.service;

import com.lsp.library.dto.PublisherDTO;
import com.lsp.library.dto.PublisherSaveDTO;
import com.lsp.library.dto.PublisherUpdateDTO;

import java.util.List;

public interface PublisherService {
    String addPublisher(PublisherSaveDTO publisherSaveDTO);

    List<PublisherDTO> getAllPublisher();

    String updatePublisher(PublisherUpdateDTO publisherUpdateDTO);

    String deletePublisher(int id);
}
