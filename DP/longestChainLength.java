//top down memoized approach
class Solution {
    int n;
    Integer[][] dp; 
    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        dp = new Integer[n][n];
        Arrays.sort(pairs,(a,b) -> a[0]-b[0]);
        return solve(pairs, 0, -1);
    }

    public int solve(int[][] nums, int i, int p){
        if(i>=n) return 0;

        if(p!=-1 && dp[i][p]!=null) return dp[i][p];

        int take = 0;
        if(p==-1 || nums[i][0]>nums[p][1]){
            take = 1+solve(nums, i+1, i);
        }
        int skip = solve(nums, i+1, p);
        
        if(p!=-1){
            dp[i][p]=Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
}


//bottom up approach
class Solution {
    int n;
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLIS = 1;

        for(int i = 0 ; i< n ; i++){
            for(int j = 0; j< i; j++){
                if(pairs[j][1]<pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLIS = Math.max(maxLIS, dp[i]);
                }
            }
        }    
        return maxLIS;
    }
}
