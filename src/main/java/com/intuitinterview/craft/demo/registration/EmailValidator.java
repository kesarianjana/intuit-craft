package com.intuitinterview.craft.demo.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
//    REFACTOR ME : Consume some email validation API's out there
       return true;
    }
}
