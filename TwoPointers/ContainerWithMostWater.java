// leet 11
//pattern - opposite left and right pointers 
public class Solution{
    public int maxArea(int[] height){
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while(left<right){
            int area = Math.min(height[left], height[right])*(right-left);
            res = Math.max(res, area);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return res;
    }
}