class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Find the maximum frequency and count of tasks with max frequency
        int maxFrequency = 0;
        int countMaxFrequency = 0;
        for (int f : freq) {
            if (f > maxFrequency) {
                maxFrequency = f;
                countMaxFrequency = 1;
            } else if (f == maxFrequency) {
                countMaxFrequency++;
            }
        }

        // Step 3: Calculate the minimum intervals
        int partCount = maxFrequency - 1;
        int partLength = n - (countMaxFrequency - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - (maxFrequency * countMaxFrequency);
        int idleSlots = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idleSlots;
    }
}
