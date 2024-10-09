package com.lsp.library.service.IMPL;

import com.lsp.library.dto.PublisherDTO;
import com.lsp.library.dto.PublisherSaveDTO;
import com.lsp.library.dto.PublisherUpdateDTO;
import com.lsp.library.entity.Publisher;
import com.lsp.library.repo.PublisherRepo;
import com.lsp.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceIMPL implements PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;

    @Override
    public String addPublisher(PublisherSaveDTO publisherSaveDTO) {
        Publisher publisher = new Publisher(
                publisherSaveDTO.getName()
        );
        publisherRepo.save(publisher);
        System.out.println("Publisher Saved Sucessfully");
        return publisher.getName();
    }

    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> getPublishers = publisherRepo.findAll(); // find all data from the entity.
        List<PublisherDTO> publisherDTOList = new ArrayList<>(); // DTOList, convert entity format to DTO form.

        for (Publisher publisher : getPublishers) { // get  Authors from all the authors
            PublisherDTO publisherDTO = new PublisherDTO( // convert it to DTO format.
                    publisher.getPublisherId(),
                    publisher.getName()
            );
            publisherDTOList.add(publisherDTO);
        }
        return publisherDTOList;
    }

    @Override
    public String updatePublisher(PublisherUpdateDTO publisherUpdateDTO) {
        if(publisherRepo.existsById(publisherUpdateDTO.getPublisherId())) {
            Publisher publisher = publisherRepo.getById(publisherUpdateDTO.getPublisherId());
            publisher.setName(publisherUpdateDTO.getName());
            publisherRepo.save(publisher);
            return publisher.getName();
        } else {
            System.out.println("Publisher Does Not Exist: ");
        }
        return null;
    }

    @Override
    public String deletePublisher(int id) {
        if(publisherRepo.existsById(id)) {
            publisherRepo.deleteById(id);

        } else {
            System.out.println("Publisher Does Not Exist: ");
        }
        return null;
    }

}
