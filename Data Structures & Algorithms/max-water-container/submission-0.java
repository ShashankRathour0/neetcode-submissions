class Solution {
    public int maxArea(int[] heights) {
          int left = 0; // Left pointer
        int right = heights.length - 1; // Right pointer
        int maxArea = 0;

        while (left < right) {
            // Calculate the area with current left and right pointers
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter bar
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
