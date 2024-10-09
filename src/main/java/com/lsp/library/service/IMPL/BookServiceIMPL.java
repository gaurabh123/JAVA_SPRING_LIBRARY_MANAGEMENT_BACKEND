package com.lsp.library.service.IMPL;

import com.lsp.library.dto.BookDTO;
import com.lsp.library.dto.BookSaveDTO;
import com.lsp.library.dto.BookUpdateDTO;
import com.lsp.library.entity.Book;
import com.lsp.library.repo.AuthorRepo;
import com.lsp.library.repo.BookRepo;
import com.lsp.library.repo.PublisherRepo;
import com.lsp.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    @Autowired
    private BookRepo bookRepo;

    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {
        Book book = new Book(
                bookSaveDTO.getTitle(),
                authorRepo.getById(bookSaveDTO.getAuthorId()),
                publisherRepo.getById(bookSaveDTO.getPublisherId())
        );
        bookRepo.save(book);
        System.out.println("Book Added Successfully");
        return bookSaveDTO.getTitle();
    }

    @Override
    public List<BookDTO> getAllBook() {
        List<Book> getBooks = bookRepo.findAll(); // find all data from the entity book
        List<BookDTO> bookDTOList = new ArrayList<>(); // DTOList, convert entity format to DTO form.

        for (Book book : getBooks) { // get  Books from all the books
            BookDTO bookDTO = new BookDTO( // convert it to DTO format.
                    book.getBookId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublisher()
            );
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    @Override
    public String updateBook(BookUpdateDTO bookUpdateDTO) {
        if (bookRepo.existsById(bookUpdateDTO.getBookId())) {
            Book book = bookRepo.getById(bookUpdateDTO.getBookId());
            book.setTitle(bookUpdateDTO.getTitle());
            book.setAuthor(authorRepo.getById(bookUpdateDTO.getAuthorId())); //foreign key for authorTable
            book.setPublisher(publisherRepo.getById(bookUpdateDTO.getPublisherId())); // foreign key for publisherTable
            bookRepo.save(book);
            return book.getTitle();
        } else {
            System.out.println("Book Not Found");
        }
        return null;
    }

    @Override
    public String deleteBook(int id) {
        if(bookRepo.existsById(id)) {
            bookRepo.deleteById(id);

        } else {
            System.out.println("Book Does Not Exist: ");
        }
        return null;
    }
}
