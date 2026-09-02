// leet 56
class Solution {
    public int[][] merge(int[][] intervals) {
        //sort the array
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for(int i=1; i<intervals.length; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            int[] lastInterval = result.get(result.size()-1);

            //if no overlap
            if(currStart>lastInterval[1]){
                result.add(intervals[i]);
            }
            else{
                //if overlap exists
                lastInterval[1] = Math.max(lastInterval[1], currEnd);
            }
        }
        //convert List to int[][]
        return result.toArray(new int[result.size()][]);
    }
}
