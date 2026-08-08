// leet 300

//top down memoized approach
class Solution {
    int n;
    Integer[][] dp; 
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new Integer[n][n];
        return solve(nums, 0, -1);
    }

    public int solve(int[] nums, int i, int p){
        if(i>=n) return 0;

        if(p!=-1 && dp[i][p]!=null) return dp[i][p];

        int take = 0;
        if(p==-1 || nums[i]>nums[p]){
            take = 1+solve(nums, i+1, i);
        }
        int skip = solve(nums, i+1, p);
        
        if(p!=-1){
            dp[i][p]=Math.max(take, skip);
        }
        return Math.max(take, skip);
    }


    //bottom up approach
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int maxLIS = 1;

            for(int i = 0 ; i< n ; i++){
                for(int j = 0; j< i; j++){
                    if(nums[j]<nums[i]){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                        maxLIS = Math.max(maxLIS, dp[i]);
                    }
                }
            }
            
            return maxLIS;
        }
    }
}