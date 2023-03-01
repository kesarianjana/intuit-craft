package com.intuitinterview.craft.demo.registration;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
}
