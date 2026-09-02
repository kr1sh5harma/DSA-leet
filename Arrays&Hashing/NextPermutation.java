class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        //find the first decreasing element from the right
        int index = -1;

        for(int i=n-1; i>0; i--){
            if(nums[i]>nums[i-1]){
                index = i-1;
                break;
            }
        }

        //if such an element exists
        if(index!=-1){
            //find the smallest element greater than nums[index]
            int swapIndex = index+1;
            for(int i=n-1; i>=index+1; i--){
                if(nums[i]>nums[index]){
                    swapIndex = i;
                    break;
                }
            }
            //swap them
            swap(nums, index, swapIndex);
        }
        //reverse only the part after index
        reverse(nums, index+1, n-1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i]; 
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
