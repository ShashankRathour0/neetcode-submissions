class Solution {
    public boolean isHappy(int n) {
        // A set to track the numbers we have already seen
        HashSet<Integer> seen = new HashSet<>();
        
        while (n != 1) {
            if (seen.contains(n)) {
                // If we encounter the same number again, we are in a cycle
                return false;
            }
            seen.add(n);
            n = sumOfSquares(n); // Replace n with the sum of the squares of its digits
        }
        
        return true; // If we reach 1, it is a non-cyclical number
    }
    
    // Helper method to compute the sum of the squares of digits
    private int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
