class Solution {
    public boolean isPowerOfFour(int n) {
    if(n == 1){
            return true;
        }
        if(n <=0){
            return false;
        }
        return (n % 4 == 0) && isPowerOfFour(n / 4);
    }
    public boolean powerOfFour(int n, int pow){
        if(Math.pow(4 , pow) == n){
            return true;
        }
        if(Math.pow(4 , pow) > n){
            return false;
        }
        return powerOfFour(n,pow + 1);
    }
}
