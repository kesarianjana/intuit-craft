package com.intuitinterview.craft.demo.registration;

public interface IRegistrationService {
    RegistrationResponse register(RegistrationRequest request);
    RegistrationResponse confirm(String token);
}
