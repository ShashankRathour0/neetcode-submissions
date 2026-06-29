class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
          Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Sort queries while keeping their original indices
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        // Min-Heap to store intervals by their lengths
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1] - a[0] + 1));
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        int i = 0; // Pointer for intervals
        for (int[] query : sortedQueries) {
            int q = query[0], index = query[1];

            // Add intervals that start before or at the query point
            while (i < intervals.length && intervals[i][0] <= q) {
                minHeap.offer(new int[] { intervals[i][0], intervals[i][1] });
                i++;
            }

            // Remove intervals that end before the query point
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            // If the heap is not empty, the top interval is the smallest valid interval
            if (!minHeap.isEmpty()) {
                int[] smallest = minHeap.peek();
                result[index] = smallest[1] - smallest[0] + 1;
            }
        }

        return result;
    }
}
