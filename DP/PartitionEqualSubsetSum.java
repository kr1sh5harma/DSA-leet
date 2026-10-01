// leet 416
class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if(sum%2!=0) return false;
        int x = sum/2;
        dp = new Boolean[nums.length][x + 1];
        return solve(nums, 0, x);
    }

    private boolean solve(int[] nums, int i, int x){
        if(x==0) return true;
        if(i>=nums.length) return false;

        if (dp[i][x] != null) {
            return dp[i][x];
        }

        boolean take = false;
        if(nums[i] <= x){
            take = solve(nums, i+1, x-nums[i]);
        }
        boolean skip = solve(nums, i+1, x);

        return dp[i][x] = take || skip;
    }
}
