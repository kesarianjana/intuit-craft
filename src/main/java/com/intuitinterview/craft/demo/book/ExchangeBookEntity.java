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
@Builder
@Table(name = "exchange")
public class ExchangeBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long Id;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "user_1")
    private String user1;

    @Column(name = "user_2")
    private String user2;

    @Column(name = "exchange_date")
    private LocalDateTime exchangeDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "isSuccessful")
    private boolean isSuccessful;
}

