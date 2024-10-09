package com.lsp.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Author Class
 *
 */
@Entity
@Table(name="author")
public class Author {

    @Setter
    @Getter
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id", length = 11)
    private int authorId;

    @Setter
    @Getter
    @Column(name = "name", length = 100)
    private String name;

    @OneToMany(mappedBy = "author") // sql table relationship, one author is mapped by set of books.
    // one author has many books.
    private Set<Book> books;

    public Author(int authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                '}';
    }
}
