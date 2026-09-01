// leet 118
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<numRows; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    list.add(1);
                }
                else{
                    int num = result.get(i-1).get(j) + result.get(i-1).get(j-1);
                    list.add(num);
                }
            }
            result.add(list);
        }
        return result;
    }
}
