package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(23);
        al.add(43);
        al.add(34);
        al.add(56);

        List<Integer> newal = al.stream().filter(i->i%2 == 0).toList();//same as collect(Collectors.toList())
        System.out.println(newal);
        System.out.println(al);
    }
}
