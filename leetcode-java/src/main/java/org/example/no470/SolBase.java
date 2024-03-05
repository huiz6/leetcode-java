package org.example.no470;

public class SolBase {

    public int rand7() {
        return (int) (Math.random() * 7) + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i ++) {
            System.out.println(new SolBase().rand7());
        }
    }

}
