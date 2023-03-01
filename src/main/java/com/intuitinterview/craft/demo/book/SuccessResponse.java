package com.intuitinterview.craft.demo.book;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse {
    private String message;
    private String code;
}
