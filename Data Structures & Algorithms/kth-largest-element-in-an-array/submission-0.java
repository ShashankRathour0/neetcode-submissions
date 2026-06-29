class Solution {
    public int findKthLargest(int[] nums, int k) {
         int n = nums.length;
        return quickselect(nums, 0, n - 1, n - k);
    }
    private int quickselect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        // Randomly choose a pivot index to avoid worst-case performance
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);

        // Partition the array around the pivot
        pivotIndex = partition(nums, left, right, pivotIndex);

        // The pivot is in its final position
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickselect(nums, left, pivotIndex - 1, k);
        } else {
            return quickselect(nums, pivotIndex + 1, right, k);
        }
    }

    // Partition function that arranges the elements
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        // Move the pivot element to the end
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        // Move all elements smaller than the pivot to the left
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        // Move the pivot element to its correct position
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    // Swap helper function
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
