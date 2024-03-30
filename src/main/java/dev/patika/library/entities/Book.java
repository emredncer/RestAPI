package dev.patika.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "book", nullable = false)
    @NotNull
    private String name;

    @Column(name = "publication_year")
    private int publicationYear;

    @Column(name = "stock")
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Borrowing> borrowingList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book2cats",
            joinColumns = {@JoinColumn(name = "book2cats_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book2cats_category_id")}
    )
    private List<Category> categoryList;
}
