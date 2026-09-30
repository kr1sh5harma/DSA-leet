// leet 5
//basic recursive code
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int sp = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(solve(s, i, j)){
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp+maxLen);
    }

    public boolean solve(String s, int i, int j){
        if(i >= j) return true;

        if(s.charAt(i)==s.charAt(j)) return solve(s, i+1, j-1);
        return false;
    }
}

//top down memoized code
class Solution {
    int[][] dp;
    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        int maxLen = Integer.MIN_VALUE;
        int sp = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(solve(s, i, j)){
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp+maxLen);
    }

    public boolean solve(String s, int i, int j){
        if(i >= j) return true;
        if(dp[i][j]!=-1) return dp[i][j]==1;

        if(s.charAt(i) == s.charAt(j)) {
            dp[i][j] = solve(s, i + 1, j - 1) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }
        
        return dp[i][j]==1;
    }
}
