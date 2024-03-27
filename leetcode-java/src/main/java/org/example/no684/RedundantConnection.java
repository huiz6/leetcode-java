package org.example.no684;

import java.util.Arrays;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (uf.isConnected(u, v)) {
                return edge;
            }
            uf.connect(u, v);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] edge1 = new int[]{1, 2};
        int[] edge2 = new int[]{1, 3};
        int[] edge3 = new int[]{2, 3};
        int[][] edges = new int[][]{edge1, edge2, edge3};
        RedundantConnection redundantConnection = new RedundantConnection();
        System.out.println(Arrays.toString(redundantConnection.findRedundantConnection(edges)));
    }

}
