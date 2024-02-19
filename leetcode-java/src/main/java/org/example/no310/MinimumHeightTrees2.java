package org.example.no310;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees2 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> resList = new ArrayList<>();
        if (n <= 1) {
            for (int i = 0; i < n; i++) {
                resList.add(i);
            }
            return resList;
        }

        int[] indegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (graph.containsKey(edge[0])) {
                graph.get(edge[0]).add(edge[1]);
            } else {
                graph.put(edge[0], new ArrayList<Integer>() {{
                    add(edge[1]);
                }});
            }
            if (graph.containsKey(edge[1])) {
                graph.get(edge[1]).add(edge[0]);
            } else {
                graph.put(edge[1], new ArrayList<Integer>() {{
                    add(edge[0]);
                }});
            }
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 1) {
                queue.addLast(i);
            }
        }

        while (n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int node = queue.pop();
                for (int adjustNode : graph.get(node)) {
                    indegree[adjustNode]--;
                    if (indegree[adjustNode] == 1) {
                        queue.add(adjustNode);
                    }
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
//        int[] edge1 = new int[]{1, 0};
//        int[] edge2 = new int[]{1, 2};
//        int[] edge3 = new int[]{1, 3};

        int[] edge1 = new int[]{3, 0};
        int[] edge2 = new int[]{3, 1};
        int[] edge3 = new int[]{3, 2};
        int[] edge4 = new int[]{3, 4};
        int[] edge5 = new int[]{5, 4};

        int[][] edges = new int[][]{edge1, edge2, edge3, edge4, edge5};
        int n = 6;
        System.out.println(new MinimumHeightTrees2().findMinHeightTrees(n, edges).toString());
    }
}
