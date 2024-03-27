package org.example.no210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        List<Integer> resList = new ArrayList<>();
        int[] indegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
                resList.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int nextCourse : graph.get(course)) {
                indegrees[nextCourse]--;
                if (indegrees[nextCourse] == 0) {
                    queue.add(nextCourse);
                    resList.add(nextCourse);
                }
            }
        }

        return resList.size() != numCourses ? new int[]{} : resList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int numCourses1 = 2;
        int[] prerequisite11 = new int[]{1, 0};
        int[][] prerequisites1 = new int[][]{prerequisite11};
        System.out.println(Arrays.toString(courseScheduleII.findOrder(numCourses1, prerequisites1)));

        int numCourses2 = 4;
        int[] prerequisite21 = new int[]{1, 0};
        int[] prerequisite22 = new int[]{2, 0};
        int[] prerequisite23 = new int[]{3, 1};
        int[] prerequisite24 = new int[]{3, 1};
        int[][] prerequisites2 = new int[][]{prerequisite21, prerequisite22, prerequisite23, prerequisite24};
        System.out.println(Arrays.toString(courseScheduleII.findOrder(numCourses2, prerequisites2)));
    }

}
