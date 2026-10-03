// leet 494
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(nums, 0, target, 0);
    }

    private int solve(int[] nums, int i, int target, int currSum){
        if(i==nums.length){
            if(currSum==target) return 1;
            else return 0;
        }
        int addWays = solve(nums, i+1, target, currSum+nums[i]);
        int subWays = solve(nums, i+1, target, currSum-nums[i]);

        return addWays + subWays;
    }
}
