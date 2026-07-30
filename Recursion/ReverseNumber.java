public class Solution{
    public int reverse(int n){
        if (num >= 0 && num < 10) {
            return num;
        }

        // Determine the number of digits in the current number minus one
        int numberOfDigits = (int) Math.log10(num);

        // Extract the last digit
        int lastDigit = num % 10;

        // Shift the last digit to its new highest place value
        int shiftedDigit = lastDigit * (int) Math.pow(10, numberOfDigits);

        // Recursive call with the remaining digits
        return shiftedDigit + reverse(num / 10); 
    }
}