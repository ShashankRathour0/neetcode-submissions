class Solution {
    public int evalRPN(String[] tokens) {
         Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isOperator(token)) {
                // Pop the top two numbers
                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand
                
                // Perform the operation
                int result = applyOperation(a, b, token);
                
                // Push the result back onto the stack
                stack.push(result);
            } else {
                // Push the operand onto the stack
                stack.push(Integer.parseInt(token));
            }
        }
        
        // The result will be the only value left in the stack
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private int applyOperation(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Integer division truncates towards zero
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    
    }
}
