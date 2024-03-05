package org.example.no470;

public class ImplementRand10UsingRand7 extends SolBase {

    public int rand10() {
        int rand = Integer.MAX_VALUE;
        while (rand >= 40) {
            rand = (rand7() - 1) * 7 + rand7();
        }
        return rand % 10 + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i ++) {
            System.out.println(new ImplementRand10UsingRand7().rand10());
        }
    }
}
