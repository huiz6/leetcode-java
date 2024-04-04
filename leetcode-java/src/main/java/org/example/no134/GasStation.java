package org.example.no134;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasLength = gas.length;
        for (int i = 0; i < gas.length; i++) {
            int j = i;
            int remain = gas[j];
            while (remain >= cost[j]) {
                remain = remain + gas[(j + 1) % gasLength] - cost[j];
                j = (j + 1) % gasLength;
                if (j == i) {
                    return i;
                }
            }

            if (j < i) {
                return -1;
            }
            i = j;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(gas, cost));
    }

}
