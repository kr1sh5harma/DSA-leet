// leet 647
//Recursive solution
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();


        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(checkPal(s, i, j)){
                    count++;
                }
            }
        }

        return count;
    }

    private boolean checkPal(String s, int i, int j){
        if(i > j) return true;

        if(s.charAt(i)==s.charAt(j)) return checkPal(s, i+1, j-1);
        return false;
    }
}

//top down memoization code 
class Solution {
    int[][] dp;
    public int countSubstrings(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(checkPal(s, i, j)){
                    count++;
                }
            }
        }

        return count;
    }

    private boolean checkPal(String s, int i, int j){
        if(i > j) return true;
        if(dp[i][j]!=-1) return dp[i][j]==1;

        if(s.charAt(i) == s.charAt(j)) {
            dp[i][j] = checkPal(s, i + 1, j - 1) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j]==1;
    }
}
