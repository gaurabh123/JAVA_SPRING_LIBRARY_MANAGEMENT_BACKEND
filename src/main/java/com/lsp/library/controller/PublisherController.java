package com.lsp.library.controller;

import com.lsp.library.dto.PublisherDTO;
import com.lsp.library.dto.PublisherSaveDTO;
import com.lsp.library.dto.PublisherUpdateDTO;
import com.lsp.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// one publisher has many books.
@RestController
@CrossOrigin
@RequestMapping("api/v1/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping(path = "/save")
    public String savePublisher(@RequestBody PublisherSaveDTO publisherSaveDTO) {
        String publisherName = publisherService.addPublisher(publisherSaveDTO);
        return "Publisher Added Successfully";
    }

    @GetMapping(path="/getAllPublisher")
    public List<PublisherDTO> getAllPublisher() {
        List<PublisherDTO> allPublishers = publisherService.getAllPublisher();
        return allPublishers;
    }

    @PutMapping(path="/update")
    public String updatePublisher(@RequestBody PublisherUpdateDTO publisherUpdateDTO) {
        String publisherName = publisherService.updatePublisher(publisherUpdateDTO);
        return publisherName;
    }

    @DeleteMapping(path="/delete/{id}")
    public String deletePublisher(@PathVariable(value = "id") int id) {
        String publisherName = publisherService.deletePublisher(id);
        return "DELETED SUCCESSFULLY";
    }
}
