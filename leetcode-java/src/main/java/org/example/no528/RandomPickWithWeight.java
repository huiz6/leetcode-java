package org.example.no528;

public class RandomPickWithWeight {

    private final int[] pick;

    public RandomPickWithWeight(int[] w) {
        pick = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            pick[i] = sum;
        }
    }

    public int pickIndex() {
        int sum = this.pick[this.pick.length - 1];
        int random = (int) (sum * Math.random());
//        int random = sum - 1;
        int index = 0;
        for (int p : pick) {
            if (random < p) {
                break;
            } else {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] w = new int[]{3, 14, 1, 7};
        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(w);
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
    }

}
