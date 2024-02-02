package org.example.no455;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childIndex = 0;
        int cookieIndex = 0;
        int success = 0;
        while (childIndex < g.length && cookieIndex < s.length) {
            if (g[childIndex] <= s[cookieIndex]) {
                success++;
                cookieIndex++;
                childIndex++;
            } else {
                cookieIndex++;
            }
        }
        return success;
    }

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int[] g = {1, 2, 3};
        int[] s = {1, 2};
        int result = assignCookies.findContentChildren(g, s);
        System.out.println(result);
    }

}
