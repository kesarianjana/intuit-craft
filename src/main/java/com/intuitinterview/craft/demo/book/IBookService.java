package com.intuitinterview.craft.demo.book;

import java.util.List;

public interface IBookService {
    List<BookResponse> fetchBooks();
    String addBook(BookRequest bookRequest);
}
