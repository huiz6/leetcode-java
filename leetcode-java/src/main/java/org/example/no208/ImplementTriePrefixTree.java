package org.example.no208;

import java.util.Objects;

public class ImplementTriePrefixTree {

    private final TireNode root;

    public ImplementTriePrefixTree() {
        root = new TireNode();
    }

    public void insert(String word) {
        TireNode cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (Objects.isNull(cur.getChildNodes()[index])) {
                cur.getChildNodes()[index] = new TireNode();
            }
            cur = cur.getChildNodes()[index];
        }
        cur.setVal(true);
    }

    public boolean search(String word) {
        TireNode cur = root;
        for (char c : word.toCharArray()) {
            if (Objects.isNull(cur)) {
                break;
            }
            cur = cur.getChildNodes()[c - 'a'];
        }
        if (Objects.isNull(cur)) {
            return false;
        }
        return cur.isVal();
    }

    public boolean startsWith(String prefix) {
        TireNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (Objects.isNull(cur)) {
                return false;
            }
            cur = cur.getChildNodes()[c - 'a'];
        }
        return Objects.nonNull(cur);
    }

    public static void main(String[] args) {
        ImplementTriePrefixTree triePrefixTree = new ImplementTriePrefixTree();
        triePrefixTree.insert("apple");
        System.out.println(triePrefixTree.search("apple"));
        System.out.println(triePrefixTree.search("app"));
        System.out.println(triePrefixTree.startsWith("app"));
        triePrefixTree.insert("app");
        System.out.println(triePrefixTree.search("app"));
    }

}
