// leet 3
public class Solution{
    public int lengthOfLongestSubstring(String s){
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int res = 0;
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                l++;
            }
            set.add(s.charAt(right));
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}