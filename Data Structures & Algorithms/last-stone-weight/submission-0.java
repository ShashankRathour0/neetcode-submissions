class Solution {
    public int lastStoneWeight(int[] stones) {
          PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all stones to the max-heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Simulate the process of smashing stones
        while (maxHeap.size() > 1) {
            // Pop the two largest stones
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            // If the stones are not equal, push the remaining stone back into the heap
            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2);
            }
        }

        // If there's no stone left, return 0, else return the remaining stone
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
