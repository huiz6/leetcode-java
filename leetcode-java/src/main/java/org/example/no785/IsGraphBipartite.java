package org.example.no785;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        if (n == 0) {
            return true;
        }
        int[] color = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                queue.add(i);
                color[i] = 1;
            }

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int adjacentNode : graph[node]) {
                    if (color[adjacentNode] == 0) {
                        queue.add(adjacentNode);
                        color[adjacentNode] = color[node] == 2 ? 1 : 2;
                    } else if (color[node] == color[adjacentNode]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsGraphBipartite isGraphBipartite = new IsGraphBipartite();
        int[] adjacent11 = new int[]{1, 2, 3};
        int[] adjacent12 = new int[]{0, 2};
        int[] adjacent13 = new int[]{0, 1, 3};
        int[] adjacent14 = new int[]{0, 2};
        int[][] graph1 = new int[][]{adjacent11, adjacent12, adjacent13, adjacent14};
        System.out.println(isGraphBipartite.isBipartite(graph1));

        int[] adjacent21 = new int[]{1, 3};
        int[] adjacent22 = new int[]{0, 2};
        int[] adjacent23 = new int[]{1, 3};
        int[] adjacent24 = new int[]{0, 2};
        int[][] graph2 = new int[][]{adjacent21, adjacent22, adjacent23, adjacent24};
        System.out.println(isGraphBipartite.isBipartite(graph2));

    }
}
