package com.intuitinterview.craft.demo.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeResponse {
    @JsonProperty("exchange_id")
    private String id;
    @JsonProperty("book_return_date")
    private LocalDateTime dueDate;
}
