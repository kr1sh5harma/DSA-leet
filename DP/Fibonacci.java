// leet 509
class Solution {
    int[] dp;

    //TOP DOWN MEMOIZATION APPROACH
    public int fib(int n) {
        dp = new int[n+1];
        return solve(n);
    }

    int solve(int n){
        if(n<=1) return n;
        if(dp[n]!=0) return dp[n];
        return dp[n]=solve(n-1)+solve(n-2);
    }

    // BOTTOM UP APPROACH
    public int fib2(int n){
        if(n<=1){
            return n;
        }
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //WITH CONSTANT SPACE COMPLEXITY
    public class fib3(int n){
        if(n<=1) return n;
        int a = 0;
        int b = 1;
        int c=0; 
        for(int i=1;i<n;i++){
            int c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}