// leet 75
class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length-1;
        while(j<=k){
            if(nums[j]==0) swap(nums, i++, j++);
            else if(nums[j]==1) j++;
            else swap(nums, j++, k--);
        }
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
