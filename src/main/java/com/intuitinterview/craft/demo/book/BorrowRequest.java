package com.intuitinterview.craft.demo.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BorrowRequest {
    private String lenderId;
    private String bookId;
    private String borrowerId;
}
