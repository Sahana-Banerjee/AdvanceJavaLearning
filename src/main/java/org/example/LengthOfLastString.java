package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LengthOfLastString {
    public int lengthOfLastWord(String s) {
        final HashMap<String, Integer> lenMap = new HashMap<String, Integer>();
        String[] strar = s.split("\\s");
        int arlen = strar.length;
        Stream.of(strar).forEach(st -> lenMap.put(st, st.trim().length()));
        //return lenMap.get(strar[arlen-1]);

        //above is O(n) time complexity, 5 ms time


        List<Integer> lenL = Arrays.asList(s.split("\\s")).stream().map(st-> st.trim().length()).collect(Collectors.toUnmodifiableList());
        return lenL.get(lenL.size()-1);

        //the above is better space complexity
    }
}
