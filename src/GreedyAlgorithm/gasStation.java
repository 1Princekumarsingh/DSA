package GreedyAlgorithm;

public class gasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, totalCost = 0;
        int availGas = 0, station = 0;

        //int idx = (start + i) % n --> we have to check at which station gas is surplus
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            availGas += gas[i] - cost[i];

            if (availGas < 0) {
                availGas = 0;
                station = i + 1;
            }
        }

        return totalGas >= totalCost ? station : -1;
    }
}
