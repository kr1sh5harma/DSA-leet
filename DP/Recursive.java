public class Main{
    static int[] weight = {1, 3, 4, 5};
    static int[] value = {1, 4, 5, 7};
    static int n = weight.length;

    public static void main(String[] args){
        int capacity = 7;
        System.out.print(solve(0, capacity));
    }

    static int solve(int i, int capacity){
        if(i==n || capacity==0) return 0;

        int skip = solve(i+1, capacity);

        int take = 0;
        if(weight[i]<=capacity){
            take = value[i] + solve(i+1, capacity-weight[i]);
        }

        return Math.max(skip, take);
    }
} 