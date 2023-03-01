package com.intuitinterview.craft.demo.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BorrowResponse {
    private String borrowerId;
    private String lenderId;
    private String bookId;
    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;
    private boolean isSuccessful;
}
/*
Response Body: { "borrow_id": integer, "borrower_id": integer,
"lender_id": integer, "book_id": integer, "exchange_date": "date", "is_successful": boolean }
 */
