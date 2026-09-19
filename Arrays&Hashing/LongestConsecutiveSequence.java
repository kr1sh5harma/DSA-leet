// leet 128
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);

        int longestStreak = 0;
        for(int i:set){
            if(!set.contains(i-1)){
                int currentNum = i;
                int currentStreak = 1;
                while(set.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }
        return longestStreak;
    }
}
