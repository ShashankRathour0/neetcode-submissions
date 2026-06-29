class Solution {
    public int[] topKFrequent(int[] nums, int k) {
           Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: frequency count
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: buckets
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        // Step 3: collect top k
        List<Integer> result = new ArrayList<>();

        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }

        // Convert to array
        return result.stream().mapToInt(i -> i).toArray();
    }
}
