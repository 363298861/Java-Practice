package Leetcode;

public class No134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int l = gas.length;

        for(int i = 0; i < l; i++){
            if(gas[i] >= cost[i]){
                int j = 0;
                int gasSum = 0, costSum = 0;
                while(j < l){
                    gasSum += gas[(i + j) % l];
                    costSum += cost[(i + j) % l];
                    if(costSum > gasSum) break;
                    j++;
                }
                if(j == l) return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuitModified(int[] gas, int[] cost){
        int start = 0, total = 0, tank = 0;
        for(int i = 0; i < gas.length; i++){
            if((tank = tank + gas[i] - cost[i]) < 0){
                start = i + 1;
                total += tank;
                tank = 0;
            }
        }
        return total + tank < 0 ? -1 : start;
    }
}
