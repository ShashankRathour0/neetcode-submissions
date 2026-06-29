class Solution {
    public int largestRectangleArea(int[] heights) {
       Stack<Integer> s = new Stack<>();
int ans = 0;
for (int i = 0; i < heights.length; i++) {
    // While the stack is not empty and the current height is less than the height at the index at the top of the stack
    while (!s.isEmpty() && heights[s.peek()] > heights[i]) {
        // Pop the index from the stack and calculate the area
        int height = heights[s.pop()];
        int width = s.isEmpty() ? i : i - s.peek() - 1;
        ans = Math.max(ans, height * width);
    }
    // Push the current index to the stack
    s.push(i);
}

// After processing all bars, check the remaining bars in the stack
while (!s.isEmpty()) {
    int height = heights[s.pop()];
    int width = s.isEmpty() ? heights.length : heights.length - s.peek() - 1;
    ans = Math.max(ans, height * width);
}

return ans;

        
    }
}
