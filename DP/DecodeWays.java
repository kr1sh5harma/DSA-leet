//leet 91
//top down memoization dp
class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return solve(s, 0, s.length());
    }

    private int solve(String s, int i, int n){
        if(i==n) return dp[i]=1;
        if(s.charAt(i)=='0') return dp[i]=0;
        if(dp[i]!=-1) return dp[i];
        int x = solve(s, i+1, n);
        int y = 0;
        if(i+1<n){
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
                y=solve(s, i+2, n);
            }
        }
        return dp[i]=x+y;
    }
}

//bottom up dp
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        dp[n] = 1;

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '0') dp[i] = 0; 
            else{
                dp[i] = dp[i+1]; 
                if(i+1 < n){
                    if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')){
                        dp[i] += dp[i+2];
                    }
                }
            }
        }
        return dp[0];
    }
}
