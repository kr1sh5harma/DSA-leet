// leet 1143
//top down dp
class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m+1][n+1];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(text1, text2, 0, 0);   
    }

    private int solve(String s1, String s2, int i, int j){
        if(i>=s1.length() || j>=s2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + solve(s1, s2, i + 1, j + 1);
        }

        return dp[i][j] = Math.max(solve(s1, s2, i+1, j), solve(s1, s2, i, j+1));
    }
}

//bottom up dp
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for(int row=0; row<m+1; row++){
            dp[row][0] = 0;
        }

        for(int col=0; col<n+1; col++){
            dp[0][col] = 0;
        }

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];

    }
}
