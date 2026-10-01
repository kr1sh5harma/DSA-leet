// leet 139
//top down memoization code
class Solution {
    private Boolean[] dp;
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        dp = new Boolean[s.length()];

        return solve(s, 0, wordDict);
    }

    private boolean solve(String s, int index, List<String> wordDict){
        if(index == n) return true;

        if (dp[index] != null) {
            return dp[index];
        }

        for(int endIndex = index+1; endIndex <= n; endIndex++){
            String split = s.substring(index, endIndex);
            if(wordDict.contains(split) && solve(s, endIndex, wordDict)){
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
}

//bottom up code
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordDict);
 
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i=1; i<dp.length; i++){
            for(int k=1; k<=i; k++){
                dp[i] = dp[i] || (dp[i-k] && wordSet.contains(s.substring(i-k, i)));
            }
        }
        return dp[s.length()];
    }
}
