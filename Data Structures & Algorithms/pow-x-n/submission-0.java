class Solution {
    public double myPow(double x, int n) {
           // Handle the case where n is negative
        if (n < 0) {
            x = 1 / x;
            n = -n; // We work with positive n after inversion
        }
        return helper(x, n);
    }

    private double helper(double x, int n) {
        // Base case: if n is 0, return 1 (since x^0 = 1)
        if (n == 0) {
            return 1;
        }
        
        // Recursive case: exponentiation by squaring
        double half = helper(x, n / 2);
        if (n % 2 == 0) {
            return half * half;  // If n is even, return (x^(n/2))^2
        } else {
            return half * half * x;  // If n is odd, return (x^(n/2))^2 * x
        }
    }
}
