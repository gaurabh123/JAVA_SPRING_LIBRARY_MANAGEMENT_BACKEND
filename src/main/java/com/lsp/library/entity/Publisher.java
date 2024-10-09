package com.lsp.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="publisher")
public class Publisher {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisher_id", length = 11)
    private int publisherId;

    @Setter
    @Getter
    @Column(name = "name", length = 100)
    private String name;

    @OneToMany(mappedBy = "publisher") // sql table relationship, one publisher is mapped by set of books.
    // one publisher has many books.
    private Set<Book> books;

    public Publisher(int publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                '}';
    }
}
