class MedianFinder {
 private PriorityQueue<Integer> maxHeap;
    // Min-heap for the larger half of the numbers
    private PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max-heap
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        // Ensure max-heap's root is smaller than min-heap's root
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }
        // Balance the sizes: max-heap can have at most one extra element
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
