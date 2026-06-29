class KthLargest {
private int k;
    private PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
          this.k = k;
        minHeap = new PriorityQueue<>(k); // Min-heap to store the k largest elements
        
        // Add initial elements from the nums array to the heap
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else {
            // If the heap already has k elements, add the new value and remove the smallest element
            if (val > minHeap.peek()) {
                minHeap.poll(); // Remove the smallest element (root of min-heap)
                minHeap.offer(val); // Add the new value
            }
        }
        
        // The root of the min-heap is the kth largest element
        return minHeap.peek();
    }
}
