package org.example;

public class StudentsWithMaxAverage {
    public static String calculateStudentAverage(String[][] s, int N){
        /*
        The given program takes a list of lists containing student names and their scores in three subjects,
        and calculates the average score for each student. It then finds the student with the maximum average score
         and prints their name and average score

        ALGORITHM:

        1. Traverse the file data and store average scores for each student.
        2. Now, find the maximum average score and search for all the students with this maximum average score.
        3. Print the maximum average score and names as per the order in the file.
         */

        int max = Integer.MIN_VALUE;
        String result = "";

        for(int i=0; i<N; i++){
            int avg = Integer.parseInt(s[i][1]) + Integer.parseInt(s[i][2]) + Integer.parseInt(s[i][3]) /3;

            if(avg > max){
                max = avg;
                result = s[i][0];
            } else if(avg ==  max){
                result = result + " " + max;
            }

        }
        return result +":"+ max;

//        return "";
    }

    public static void main(String[] args) {
        int N = 2;
        String[][] file= { {"Shrikanth", "-120", "-130" ,"-10"},
                {"Ram" ,"-100", "-50", "-10"}};

        System.out.println(calculateStudentAverage(file, N));
    }
}
