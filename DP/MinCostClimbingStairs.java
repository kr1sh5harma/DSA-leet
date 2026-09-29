// leet 746

// top down memoization
class Solution{
    int[] dp;  
    public int minCostClimbingStairs(int[] cost){
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(solve(cost, 0), solve(cost, 1));
    }

    public int solve(int[] cost, int i){
        if(i >= cost.length) return 0;
        if(dp[i] != -1) return dp[i];
        int a = cost[i] + solve(cost, i+1);
        int b = cost[i] + solve(cost, i+2);
        return dp[i] = Math.min(a, b);
    }
}

//bottom up
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==2) return Math.min(cost[0], cost[1]);

        for(int i=2; i<n; i++){
            cost[i] = cost[i] + Math.min(cost[i-1], cost[i-2]); 
        }

        return Math.min(cost[n-1], cost[n-2]);
    }
}
