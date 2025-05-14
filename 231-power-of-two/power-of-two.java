class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }
        if(n % 2 != 0){
            return false;
        }
        return powerOfTwo(n,1);
    }
    public boolean powerOfTwo(int n, int pow){
        if(Math.pow(2 , pow) == n){
            return true;
        }
        if(Math.pow(2 , pow) > n){
            return false;
        }
        return powerOfTwo(n,pow + 1);
    }
}