class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cost = prices[0];
        for(int i=0;i<prices.length;i++){
            int diff = prices[i] - cost;
            profit = Math.max(diff,profit);
            cost = Math.min(cost,prices[i]);
        }
        return profit;
    }
}