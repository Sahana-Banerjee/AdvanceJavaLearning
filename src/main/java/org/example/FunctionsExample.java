package org.example;

import java.util.function.Function;

public class FunctionsExample {
    public static void main(String[] args) {
        //Here the FI Function accepts String type input and return and Integer
        Function<String, Integer> customFunct = s -> s.length();
        System.out.println(customFunct.apply("Sahana"));
    }
}
