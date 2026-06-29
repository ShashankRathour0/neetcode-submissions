class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Handle closing brackets
            else {
                if (stack.isEmpty()) return false; // No matching opening bracket
                
                char top = stack.pop();
                // Check for mismatched brackets
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // Stack should be empty if all brackets are matched
        return stack.isEmpty();
    }
}
