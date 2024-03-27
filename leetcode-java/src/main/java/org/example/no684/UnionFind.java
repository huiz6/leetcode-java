package org.example.no684;

public class UnionFind {

    private final int[] id;

    public UnionFind(int n) {
        this.id = new int[n];
        for (int i = 0; i < n; i++) {
            this.id[i] = i;
        }
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void connect(int p, int q) {
        id[find(p)] = find(q);
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

}
