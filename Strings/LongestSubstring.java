//leet 3
// pattern - longest substring without repeating
class Solution{
    public int lengthOfLongestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int res = 0;
        for(int right=0; right<s.length(); right++){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}