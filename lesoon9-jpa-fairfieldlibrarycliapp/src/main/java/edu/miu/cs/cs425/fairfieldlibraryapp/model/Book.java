package edu.miu.cs.cs425.fairfieldlibraryapp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "books")
@NamedQuery(name = "Book.getCheapBooks",query = "select b from Book b where b.costPrice.amount <10")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId ;

    @Column(unique = true,nullable = false)
    private String isbn;

    @NotBlank(message = "Book title must not be black or empty or null")
    @Column(nullable = false)
    private String title ;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate datePublished ;

    private Integer numberOfCopies ;


    @Embedded   //-->
    private Money costPrice ;



    @ManyToMany
    @JoinTable(name = "books_authors_id",
    joinColumns = {@JoinColumn(name = "book_id",referencedColumnName = "bookId")},//bookid -->instance property
    inverseJoinColumns = {@JoinColumn(name = "authorId",referencedColumnName = "authorId")})   //authorId from instance variable of author class

    private List<Author> authors ;



    //@OneToMany  //one book to many publisher

    @ManyToOne(cascade = CascadeType.PERSIST)   //many book to one publisher
    @JoinColumn(name = "publisher_id",nullable = false)
    private Publisher publisher ;


    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
