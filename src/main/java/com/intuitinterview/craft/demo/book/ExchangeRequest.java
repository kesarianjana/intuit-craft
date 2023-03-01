package com.intuitinterview.craft.demo.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ExchangeRequest {
    private final String bookId1;
    private final String bookId2;
    private final String user1_id;
    private final String user2_id;

}
