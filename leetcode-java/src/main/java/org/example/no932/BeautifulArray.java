package org.example.no932;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulArray {

    public int[] beautifulArray(int n) {
        List<Integer> resultList = new ArrayList<Integer>(){{
            add(1);
        }};
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        while (resultList.size() < n) {
            leftList.clear();
            rightList.clear();
            for (int num : resultList) {
                leftList.add(2 * num - 1);
                rightList.add(2 * num);
            }
            resultList.clear();
            resultList.addAll(leftList);
            resultList.addAll(rightList);
        }
        return resultList.stream().filter(o -> o <= n).mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        int[] resultArray = new BeautifulArray().beautifulArray(7);
        System.out.println(Arrays.toString(resultArray));
    }
}
