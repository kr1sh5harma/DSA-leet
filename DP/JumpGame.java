// leet 55
// recursion memoization
class Solution {
    boolean[] dp;
    public boolean canJump(int[] nums) {
        dp = new boolean[nums.length+1];
        return solve(nums, 0);
    }

    public boolean solve(int[] nums, int idx){
        if(idx>=nums.length-1) return true;
        if(dp[idx] != null) return dp[idx];
        for(int i=1; i<=nums[idx]; i++){
            if(solve(nums, i+1)) return dp[idx]=true;
        }
        return dp[idx]=false;
    }
}

//bottom up
class Solution {
    public boolean canJump2(int[] nums){
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i=1; i<nums.length; i++){
            for(int j=i-1; j>=0; j--){
                if(dp[j]==true && j+nums[j]>=i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}

//fastest approach
public class Solution{
  public static boolean canJump3(int[] nums){
          int n = nums.length;
          int maxReachable = 0;
          for(int i=0; i<n; i++){
              if(i>maxReachable) return false;
              maxReachable = Math.max(maxReachable, i+nums[i]);
          }
          return true;
    }
  
}
