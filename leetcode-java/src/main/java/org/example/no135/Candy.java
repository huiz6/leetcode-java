package org.example.no135;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Candy {

    public int candy(int[] ratings) {
        int[] distribution = new int[ratings.length];
        Arrays.fill(distribution, 1);
        if (ratings.length == 1) {
            return 1;
        }
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                distribution[i + 1] = distribution[i] + 1;
            }
        }

        for (int i = ratings.length; i > 1; i--) {
            if (ratings[i - 2] > ratings[i - 1]) {
                distribution[i - 2] = Integer.max(distribution[i - 2], distribution[i - 1] + 1);
            }
        }
        System.out.println(Arrays.toString(distribution));
        return IntStream.of(distribution).sum();
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratings = {1, 3, 4, 5, 2};
        System.out.println(candy.candy(ratings));
    }

}
