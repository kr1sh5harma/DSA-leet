// leet 3345
class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(productOfDigits(n)%t==0) return n;
            n++;
        }        
    }

    public int productOfDigits(int n){
        int product=1;
        while(n>0){
            product *= (n % 10);
            n = n/10;
        }
        return product;
    }
}