package org.example.no77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int pos = 0;
        this.dfs(n, pos, 1, k, path, resList);
        return resList;
    }

    private void dfs(int n, int pos, int start, int k, Deque<Integer> path, List<List<Integer>> resList) {
        if (pos == k) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            this.dfs(n, pos + 1, i + 1, k, path, resList);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 12, k = 12;
        List<List<Integer>> resList = new Combinations().combine(n, k);
        for (List<Integer> res : resList) {
            System.out.println(res.toString());
        }
    }

}
