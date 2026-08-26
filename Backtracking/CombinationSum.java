class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> temp = new ArrayList<>();
        backtrack(candidates, target, 0, temp);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> temp){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<candidates.length; i++){
            if(candidates[i]>target) continue;
            temp.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i, temp);
            temp.remove(temp.size()-1);
        }
    }
}
