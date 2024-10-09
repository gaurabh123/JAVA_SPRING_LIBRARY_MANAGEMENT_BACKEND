package com.lsp.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="book")
public class Book {

    @Setter
    @Getter
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", length = 11)
    private int bookId;

    @Setter
    @Getter
    @Column(name = "book_title", length = 45)
    private String title;

    @Setter
    @Getter
    @ManyToOne // many to one join column, author_id will go to book table.
    @JoinColumn(name = "author_id")
    private Author author;

    @Setter
    @Getter
    @ManyToOne // many to one join column, publisher_id will go to book table.
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Book(int bookId, String title, Author author, Publisher publisher) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public Book(String title, Author author, Publisher publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
