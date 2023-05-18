package com.example.musiccamp.registration;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        //implement regex to validate email;
        return true;
    }
}
