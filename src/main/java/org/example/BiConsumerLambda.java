package org.example;

import java.util.function.BiConsumer;

public class BiConsumerLambda {
    public static void main(String[] args) {

        BiConsumer<Integer, Integer> consumer =  (a, b) -> System.out.println(a+b);
        consumer.accept(10 ,23);
    }
}