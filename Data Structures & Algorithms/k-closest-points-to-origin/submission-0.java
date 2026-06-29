class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1])
        );
        
        // Iterate through the points and add them to the max-heap
        for (int[] point : points) {
            maxHeap.add(point);
            // If heap size exceeds k, remove the point with the largest distance
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        // Prepare the result array with the k closest points
        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }
        
        // Return the k closest points
        return result;

    }
}
