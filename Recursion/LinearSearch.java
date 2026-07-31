public class Solution{
    public boolean linearSearch(int[] arr, int target, int index){
        if(index==arr.length){
            return false;
        }
        return arr[index]==target || find(arr, target, index+1); 
    }
}