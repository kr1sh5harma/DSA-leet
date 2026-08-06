//leet 1911
class Solution {
    int n;
    long[][] dp;
    //top down memoization approach
    public long maxAlternatingSum(int[] nums) {
        n= nums.length;
        dp = new long[n][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, true);
    }

    private long solve(int[] nums, int i, boolean flag){
        if(i>=n) return 0;

        int f = flag ? 1 : 0;

        if(dp[i][f]!=-1) return dp[i][f];

        long skip = solve(nums, i+1, flag);
        long val = flag ? nums[i] : -nums[i];
    
        long take= solve(nums, i+1, !flag) + val;
        return dp[i][f]=Math.max(skip, take);
    }

    //bottom up approach 
    public long maxAlternatingSum2(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];

        for(int i=1; i<=n; i++){
            dp[i][0] = Math.max(dp[i-1][1] - nums[i-1], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] + nums[i-1], dp[i-1][1]);
        }   
        return Math.max(dp[n][0], dp[n][1]);
    }
}