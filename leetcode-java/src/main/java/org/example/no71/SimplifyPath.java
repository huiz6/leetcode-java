package org.example.no71;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] pathSplitArray = path.split("/");

        Stack<String> stack = new Stack<>();
        for (String pathSplit : pathSplitArray) {
            switch (pathSplit) {
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case ".":
                case "":
                    break;
                default:
                    stack.push(pathSplit);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString().isEmpty() ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        String path1 = "/home/./user//Documents/../Pictures";
        String path2 = "/../";
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath(path1));
        System.out.println(simplifyPath.simplifyPath(path2));
    }

}
