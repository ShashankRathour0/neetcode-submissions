class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
         int n = position.length;
        if (n == 0) return 0;

        // Pair position and speed, and sort by position in descending order
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        // Calculate time to destination for each car
        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double) (target - cars[i][0]) / cars[i][1];
        }

        // Count fleets using greedy approach
        int fleets = 0;
        double lastTime = 0;
        for (int i = 0; i < n; i++) {
            if (time[i] > lastTime) { // New fleet is formed
                fleets++;
                lastTime = time[i];
            }
        }

        return fleets;
    }
}
