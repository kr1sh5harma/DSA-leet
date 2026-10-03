// leet 97
class Solution {
    int m,n,N;
    int dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        N = s3.length();
        if(m+n != N) return false;
        dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, 0, s1, s2, s3);
    }

    public boolean solve(int i, int j, int k, String s1, String s2, String s3){
        if(i==m && j==n && k==N) return true;
        if(k>=N) return false;
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean result = false;
        if(i<m && s1.charAt(i)==s3.charAt(k)){
            result = solve(i+1, j, k+1, s1, s2, s3);
        }

        if(result==true){
            dp[i][j] = 1;
            return result;
        } 

        if(j<n && s2.charAt(j)==s3.charAt(k)){
            result = solve(i, j+1, k+1, s1, s2, s3);
        }
        dp[i][j] = result ? 1 : 0;
        return result;
    }
}
