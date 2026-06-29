class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if (nums1.length > nums2.length) {
        int[] temp = nums1;
        nums1 = nums2;
        nums2 = temp;
    }

    int m = nums1.length;
    int n = nums2.length;

    // Binary search on the smaller array (nums1)
    int left = 0, right = m;
    while (left <= right) {
        int partition1 = (left + right) / 2;
        int partition2 = (m + n + 1) / 2 - partition1;

        // Left and right elements of the partitions
        int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
        int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

        int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
        int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

        // Check if we found the correct partition
        if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
            // If the total number of elements is odd, return the max of left elements
            if ((m + n) % 2 == 1) {
                return Math.max(maxLeft1, maxLeft2);
            } else {
                // If the total number of elements is even, return the average of the max of left elements and min of right elements
                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            }
        } else if (maxLeft1 > minRight2) {
            // We need to move partition1 to the left
            right = partition1 - 1;
        } else {
            // We need to move partition1 to the right
            left = partition1 + 1;
        }
    }

    throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
