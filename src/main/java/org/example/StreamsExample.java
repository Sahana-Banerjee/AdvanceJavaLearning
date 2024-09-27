package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(23);
        al.add(43);
        al.add(34);
        al.add(56); //3
        al.add(34);
        al.add(45);
        al.add(90);
        al.add(100);//7
        al.add(89);

        List<Integer> newal = al.stream().filter(i->i%2 == 0).toList();//same as collect(Collectors.toList())
        System.out.println(newal);
        System.out.println(al);

        //Get a slice of the stream from index 3 to 7
        Stream<Integer> sliceos = al.stream().skip(3).limit(7 - 3+1);
        sliceos.forEach(i -> System.out.println(i));

        //How to Reverse elements of a Parallel Stream in Java?
        List<String> as = new ArrayList<>();
        as.add("Sahana");
        as.add("SOURAV");
        as.add("Shreeja");

        //as.stream().parallel().map(s -> s.toLowerCase()).forEach(t -> System.out.println(t));
        Stream pStream = as.parallelStream();
        pStream.collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
            Collections.reverse(l);
            System.out.println(l);
            return l.stream();
        }));
        as.stream().parallel().collect(Collectors.collectingAndThen(Collectors.toList(), l->{
            Collections.reverse(l);
            System.out.println(l);
            return l.stream();
        }));

    }
}
