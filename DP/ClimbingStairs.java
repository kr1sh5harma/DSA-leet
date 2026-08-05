class Solution {

    //plain recursion approach
    public int climbStairs(int n) {
        return solve(n);
    }
    public int solve(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        return solve(n-1)+solve(n-2);
    }
    

    //Top Down Memoization approach
    int[] dp;
    public int climbStairs2(int n) {
        dp = new int[n+1];
        return solve(n);
    }
    public int solve(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n]!=0) return dp[n];
        return dp[n]=solve(n-1)+solve(n-2);
    }

    //BOTTOM UP APPROACH
    public int climbStairs3(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }   

    //space optimized
    public int climbStairs4(int n){
        if(n<=2) return n;
        int a=1;
        int b=2;
        int c=3;
        for(int i=3;i<=n;i++){
            c=b+a;
        }
        return c;
    }
}