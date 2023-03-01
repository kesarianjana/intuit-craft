package com.intuitinterview.craft.demo.book;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "borrow")
@Builder
public class BorrowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "borrow_id")
    private Long borrowId;

    @Column(name = "borrower_id")
    private String borrowerId;

    @Column(name = "lender_id")
    private String lenderId;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "borrow_date")
    private LocalDateTime borrowDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "isSuccessful")
    private boolean isSuccessful;

}
