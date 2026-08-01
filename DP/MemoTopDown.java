public class MemoTopDown{
    static int[] weight = {};
    static int[] values = {};
    static int n = weight.length;
    static Integer[][] memo;

    public static void main(String[] args){
        int capacity = 7;
        memo = new Integer[n][capacity+1];
        System.out.print(value(0, capacity));
    }

    public static int value(int i, int capacity){
        if(i==n || capacity==0) return 0;

        if(memo[i][capacity]!=null) return memo[i][capacity];

        int skip = value(i+1, capacity);

        int take = 0;
        if(weight[i]<=capacity){
            take = value[i]+value(i+1, capacity-weight[i]);
        }
        
        return memo[i][capacity] = Math.max(skip, take);
    }
}