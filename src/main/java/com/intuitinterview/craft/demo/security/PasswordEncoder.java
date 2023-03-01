package com.intuitinterview.craft.demo.security;

import com.intuitinterview.craft.demo.appuser.AppUserRepository;
import com.intuitinterview.craft.demo.appuser.AppUserService;
import com.intuitinterview.craft.demo.registration.token.ConfirmationTokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoder {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
