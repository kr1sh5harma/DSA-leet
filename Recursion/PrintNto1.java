public class Solution{
    public void printNto1(int n){
        if(n==0) return;
        System.out.print(n);
        printNto1(n-1);
    }

    public void print1toN(int n){
        if(n==0) return;
        print1toN(n-1);
        System.out.print(n);
    }
}