// leet 567
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for(int i=0; i<m; i++){
            f1[s1.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;

        while(j < n){
            f2[s2.charAt(j)-'a']++;

            if(j-i+1 > m){
                f2[s2.charAt(i) - 'a']--;
                i++;
            }

            if(Arrays.equals(s1, s2)) return true;
            j++;
        }

        return false;
    }
}
