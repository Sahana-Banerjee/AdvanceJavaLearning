package org.example;

import java.util.function.Predicate;

public class PredicateEx {
    public static void main(String[] args) {
        Predicate<String> check = String::isBlank;
        System.out.println(check.test("I am not blank"));
    }
}
