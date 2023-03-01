package com.intuitinterview.craft.demo.registration;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationHandler registrationHandler;

    @PostMapping(value = "v1/registration" , consumes = "application/json", produces = "application/json")
    @Operation(summary = "Register a New User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully updated"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {
        return registrationHandler.register(request);
    }

    @GetMapping(path = "v1/confirm", produces = "application/json")
    @Operation(summary = "Verify a New User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully updated"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<RegistrationResponse> confirm(@RequestParam("token") String token) {
       return registrationHandler.confirm(token);
    }

}
