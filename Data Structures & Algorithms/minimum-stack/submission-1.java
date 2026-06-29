class MinStack {
 private Stack<int[]> stack; // Stack to hold pairs [value, current_min]

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            // If stack is empty, the current value is the minimum
            stack.push(new int[]{val, val});
        } else {
            // Otherwise, compare the value with the current minimum
            int currentMin = stack.peek()[1];
            stack.push(new int[]{val, Math.min(val, currentMin)});
        }
    }

    public void pop() {
        stack.pop(); // Remove the top element
    }

    public int top() {
        return stack.peek()[0]; // Return the value of the top element
    }

    public int getMin() {
        return stack.peek()[1]; // Return the minimum value of the top element
    }
}
