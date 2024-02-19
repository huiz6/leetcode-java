package org.example.no310;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTrees1 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> resList = new ArrayList<>();
        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                resList.add(i);
            }
            return resList;
        }
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
        }
        Set<Integer> verticeSet = new HashSet<>();
        List<Integer> rootList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                verticeSet.add(i);
            } else {
                rootList.add(i);
            }
        }
        Map<Integer, Integer> rootMinHeight = new HashMap<>();
        int minHeight = Integer.MAX_VALUE;
        for (int root : rootList) {
            Set<Integer> usedNode = new HashSet<Integer>() {{
                add(root);
            }};
            int height = this.dfs(root, 0, usedNode, verticeSet, graph);
            rootMinHeight.put(root, height);
            minHeight = Integer.min(minHeight, height);
        }

        for (int root : rootList) {
            if (rootMinHeight.get(root) == minHeight) {
                resList.add(root);
            }
        }
        return resList;
    }

    private int dfs(
            int node, int height, Set<Integer> usedNode, Set<Integer> verticeSet, Map<Integer, List<Integer>> graph
    ) {
        if (verticeSet.contains(node)) {
            return height;
        }

        List<Integer> adjust = graph.get(node);
        int maxHeight = Integer.MIN_VALUE;
        for (int nextNode : adjust) {
            if (usedNode.contains(nextNode)) {
                continue;
            }
            usedNode.add(nextNode);
            maxHeight = Integer.max(this.dfs(nextNode, height + 1, usedNode, verticeSet, graph), maxHeight);
            usedNode.remove(nextNode);
        }
        return maxHeight;
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
        System.out.println(new MinimumHeightTrees1().findMinHeightTrees(n, edges).toString());
    }
}
