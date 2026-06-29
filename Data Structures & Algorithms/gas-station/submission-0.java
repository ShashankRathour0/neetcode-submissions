class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int totalGas = 0, totalCost = 0; // Track total gas and cost
        int currentTank = 0;            // Gas available in the current tank
        int startIndex = 0;             // Starting station index

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i] - cost[i];

            // If tank becomes negative, reset starting index and tank
            if (currentTank < 0) {
                startIndex = i + 1;  // Move start index to next station
                currentTank = 0;    // Reset current tank
            }
        }

        // If total gas >= total cost, return start index, otherwise -1
        return totalGas >= totalCost ? startIndex : -1;
    }
}
