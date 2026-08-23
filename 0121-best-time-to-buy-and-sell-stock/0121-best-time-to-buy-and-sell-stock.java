class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        int[] max = new int[prices.length];
        int[] min = new int[prices.length];

        min[0] = prices[0];
        max[max.length-1] = prices[max.length-1];

        for(int i = max.length-2; i >= 0; i--) {
            max[i] = Math.max(prices[i], max[i+1]);
        }
        for(int i = 1; i < max.length; i++) {
            min[i] = Math.min(prices[i], min[i-1]);
        }
        for(int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, max[i] - min[i]);
        }
        return maxProfit;
    }
}