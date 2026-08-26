class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = helper(nums, target, true);
        result[1] = helper(nums, target, false);
        return result;
    }

    public int helper(int[] nums, int target, boolean firstIn){
        int st = 0;
        int end = nums.length-1;
        int ans = -1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(nums[mid]>target) end = mid-1;
            else if(nums[mid]<target) st = mid+1;
            else{
                ans = mid;
                if(firstIn) end = mid-1;
                else st = mid+1;
            }
        }
        return ans;
    }
}