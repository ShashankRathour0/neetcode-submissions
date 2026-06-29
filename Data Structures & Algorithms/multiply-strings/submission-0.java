class Solution {
    public String multiply(String num1, String num2) {
          int m = num1.length();
        int n = num2.length();
        
        // Result array will hold the product, the maximum length of the result can be m + n
        int[] result = new int[m + n];
        
        // Multiply each digit of num1 by each digit of num2
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Multiply the digits and add to the corresponding position in the result array
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1]; // Add the previous sum (carry) if any
                
                // Update the result array: result[i + j + 1] is the ones place, and result[i + j] is the tens place
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        
        // Convert the result array to a string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) { // Skip leading zeros
                sb.append(num);
            }
        }
        
        // Return the result as a string, or "0" if the result is empty
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
