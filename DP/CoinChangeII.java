// leet 518
// top down memoization
class Solution {
    int[][] dp; 
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[amount+1][n];
        for(int i=0; i<=amount; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(amount, coins, 0);
    }

    public int solve(int amount, int[] coins, int i){
        if(i==coins.length) return 0;
        if(amount==0) return 1;

        if(dp[amount][i]!=-1) return dp[amount][i];

        if(coins[i]>amount){
            return dp[amount][i] = solve(amount, coins, i+1);
        }
        
        int take = solve(amount-coins[i], coins, i);
        int skip = solve(amount, coins, i+1);
        return dp[amount][i] = take + skip;
    }
}
