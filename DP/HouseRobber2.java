// leet 213
class Solution {
    int[] dp;

    //top down memoize approach
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        dp = new int[n];
        Arrays.fill(dp, -1);
      
        int take0thHouse = solve(nums, 0, n-2);
        Arrays.fill(dp, -1);
        int take1stHouse = solve(nums, 1, n-1);
        return Math.max(take0thHouse, take1stHouse);
    }

    private int solve(int[] nums, int i, int n){
        if(i>n) return 0;

        if(dp[i]!=-1) return dp[i];

        int steal = nums[i]+solve(nums, i+2, n);
        int skip = solve(nums, i+1, n);

        return dp[i]=Math.max(steal, skip);
    }


    //bottom up approach 
    public int rob2(int[] nums){
        int n = nums.length;
        if(n==1) return nums[0];
        dp = new int[n+1];
        dp[0] =0;

        //case 1 - take 1st house - and skip last house
        for(int i=1; i<=n-1;i++){
            int skip = dp[i-1];
            int steal = nums[i-1]+((i>=2) ? dp[i-2] : 0);
            dp[i] = Math.max(skip, steal);
        }

        int result1 = dp[n-1];
        Arrays.fill(dp, 0);

        //case 2 - skip first house - and you can take last house
        dp[0]=0;
        dp[1]=0;
        for(int i=2; i<=n;i++){
            int skip = dp[i-1];
            int steal = nums[i-1]+((i>=2) ? dp[i-2] : 0);
            dp[i] = Math.max(skip, steal);
        }

        int result2 = dp[n];

        return Math.max(result1, result2);

    }

    //constant space approach
    public int rob3(int[] nums){
        int n= nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        int take1stHouse = solve(nums, 0, n-2);
        int skip1stHouse = solve(nums, 1, n-1);
        return Math.max(take1stHouse, skip1stHouse);

    }

    private int solve(int[] nums, int l, int r){
        int prev = 0;
        int prevPrev = 0;
        for(int i=l; i<=r; i++){
            int skip = prev;
            int take = nums[i]+prevPrev;
            int temp = Math.max(skip, take);
            prevPrev = prev;
            prev = temp;
        }
        return prev;
    }
}