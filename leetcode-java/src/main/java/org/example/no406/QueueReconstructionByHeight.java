package org.example.no406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return -1;
            } else if (o1[0] < o2[0]) {
                return 1;
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        List<int[]> resultList = new LinkedList<>();
        for (int[] person : people) {
            resultList.add(person[1], person);
        }
        int[][] resultArray = new int[people.length][];
        return resultList.toArray(resultArray);
    }

    public static void main(String[] args) {
        int[] people1 = {7, 0};
        int[] people2 = {4, 4};
        int[] people3 = {7, 1};
        int[] people4 = {5, 0};
        int[] people5 = {6, 1};
        int[] people6 = {5, 2};
        int[][] people = {people1, people2, people3, people4, people5, people6};
        new QueueReconstructionByHeight().reconstructQueue(people);
    }


}
