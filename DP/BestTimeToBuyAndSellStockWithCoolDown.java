// leet 309
//top down code
class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(prices, 0, n, 1);
    }

    int solve(int[] prices, int day, int n, int buy){
        if(day>=n) return 0;
        if(dp[day][buy]!=-1) return dp[day][buy];
        int profit = 0;
        if(buy==1){
            int take = solve(prices, day+1, n, 0) - prices[day];
            int not_take = solve(prices, day+1, n, 1);
            profit = Math.max(take, not_take);
        }
        else{
            int sell = prices[day] + solve(prices, day+2, n, 1);
            int not_sell = solve(prices, day+1, n, 0);
            profit = Math.max(sell, not_sell);
        }
        return dp[day][buy]= profit;
    }
}
