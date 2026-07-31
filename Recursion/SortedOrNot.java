public class Solution{
    public boolean sortedOrNot(int[] arr, int index){
        if(index==arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && sortedOrNot(arr, index+1);
    }
}