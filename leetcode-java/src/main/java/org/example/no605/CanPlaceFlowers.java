package org.example.no605;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int placeNum = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            boolean pre;
            if (i - 1 < 0) {
                pre = true;
            } else {
                pre = flowerbed[i - 1] == 0;
            }
            boolean after;
            if (i + 1 == flowerbed.length) {
                after = true;
            } else {
                after = flowerbed[i + 1] == 0;
            }

            if (pre && after && flowerbed[i] == 0
            ) {
                flowerbed[i] = 1;
                placeNum++;
            }
            if (placeNum >= n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        int[] flowerbed = {0};
        System.out.println(canPlaceFlowers.canPlaceFlowers(flowerbed, 1));
    }
}
