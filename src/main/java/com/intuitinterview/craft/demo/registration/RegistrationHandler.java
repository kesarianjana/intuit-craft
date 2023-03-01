package com.intuitinterview.craft.demo.registration;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegistrationHandler {

    private final IRegistrationService iRegistrationService;

    public ResponseEntity<RegistrationResponse> register(RegistrationRequest request) {
        RegistrationResponse response = iRegistrationService.register(request);
        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<RegistrationResponse> confirm(String token) {
        RegistrationResponse response = iRegistrationService.confirm(token);
        return ResponseEntity.ok().body(response);
    }
}
