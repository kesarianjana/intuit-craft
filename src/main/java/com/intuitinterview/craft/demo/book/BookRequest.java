package com.intuitinterview.craft.demo.book;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String coverImage;
    private String ownerId;
}
