//leet 347
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        List<Integer>[] buckets = new List[n+1];

        for(int num:map.keySet()){
            int frequency = map.get(num);
            if(buckets[frequency]==null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }
        int[] result = new int[k];
        int index = 0;
        for(int i=n; i>=1; i--){
            if(buckets[i]!=null){
                for(int num:buckets[i]){
                    result[index++] = num;
                }
                if(index==k) return result;
            }
        }
        return result;
    }
}
