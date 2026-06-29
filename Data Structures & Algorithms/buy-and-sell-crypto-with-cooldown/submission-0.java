class Solution {
    public int maxProfit(int[] prices) {
          if (prices == null || prices.length == 0) return 0;
        int n = prices.length;

        // Initialize states
        int hold = -prices[0]; // Holding a coin
        int sell = 0;          // Sold a coin
        int cooldown = 0;      // Cooldown state

        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            int prevSell = sell;
            int prevCooldown = cooldown;

            // Update states based on transitions
            hold = Math.max(prevHold, prevCooldown - prices[i]);
            sell = prevHold + prices[i];
            cooldown = Math.max(prevCooldown, prevSell);
        }

        // Maximum profit will be in either sell or cooldown state on the last day
        return Math.max(sell, cooldown);
    }
}
