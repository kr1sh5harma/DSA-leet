//leet 90
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        ArrayList<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        return result;
    }

    private void solve(int[] nums, int i, ArrayList<Integer> temp){
        if(i>=nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        solve(nums, i+1, temp);
        temp.remove(temp.size()-1);
        int j = i+1;
        while(j<nums.length && nums[i]==nums[j]) j++;
        solve(nums, j, temp);
    }
}
