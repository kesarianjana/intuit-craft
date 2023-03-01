package com.intuitinterview.craft.demo.book;

import com.intuitinterview.craft.demo.appuser.AppUser;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
@Builder
public class BookEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "book_id")
        private Long bookId;

        @Column(name = "title")
        private String title;

        @Column(name = "author")
        private String author;

        @Column(name = "publisher")
        private String publisher;

        @Column(name = "isbn")
        private String isbn;

        @Column(name = "cover_image")
        private String coverImage;

        @Column(name = "owner_id")
        private String ownerId;

    }