package org.example.no218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int[][] xyArrays = new int[buildings.length * 2][3];
        int index = 0;
        for (int[] building : buildings) {
            xyArrays[index++] = new int[]{building[0], building[2], 0};
            xyArrays[index++] = new int[]{building[1], building[2], 1};
        }
        Arrays.sort(xyArrays,
                (array1, array2) -> {
                    if (array1[0] != array2[0]) {
                        return Integer.compare(array1[0], array2[0]);
                    } else {
                        if (array1[2] == 0 && array2[2] == 0) {
                            return -Integer.compare(array1[1], array2[1]);
                        } else if (array1[2] == 1 && array2[2] == 1) {
                            return Integer.compare(array1[1], array2[1]);
                        } else if (array1[2] == 0 && array2[2] == 1) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
        );
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                Comparator.comparing(o -> -o)
        );
        int maxHeight = Integer.MIN_VALUE;
        List<List<Integer>> skyLineList = new ArrayList<>();
        for (int[] xyArray : xyArrays) {
            if (xyArray[2] == 0) {
                priorityQueue.add(xyArray[1]);
            } else {
                priorityQueue.remove(xyArray[1]);
            }
            int currentMaxHeight = priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
            if (maxHeight != currentMaxHeight) {
                maxHeight = currentMaxHeight;
                skyLineList.add(
                        new ArrayList<Integer>() {{
                            add(xyArray[0]);
                            add(currentMaxHeight);
                        }}
                );
            }
        }
        return skyLineList;
    }

    public static void main(String[] args) {
        int[] building1 = new int[]{2, 9, 10};
        int[] building2 = new int[]{3, 7, 15};
        int[] building3 = new int[]{5, 12, 12};
        int[] building4 = new int[]{15, 20, 10};
        int[] building5 = new int[]{19, 24, 8};

        int[] building6 = new int[]{0, 2, 3};
        int[] building7 = new int[]{2, 5, 3};
//        int[][] buildings = new int[][]{building1, building2, building3, building4, building5};
        int[][] buildings = new int[][]{building6, building7};
        List<List<Integer>> skyLineList = new TheSkylineProblem().getSkyline(buildings);
        System.out.println(skyLineList.toString());
    }
}
