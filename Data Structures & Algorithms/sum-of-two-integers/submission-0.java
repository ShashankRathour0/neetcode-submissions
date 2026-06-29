class Solution {

    // check this
    public int getSum(int a, int b) {
        while (b != 0) {
            // Calculate the sum without carry
            int sum = a ^ b;
            // Calculate the carry and shift left by 1
            int carry = (a & b) << 1;
            // Update a and b for the next iteration
            a = sum;
            b = carry;
        }
        return a;
    }
}
