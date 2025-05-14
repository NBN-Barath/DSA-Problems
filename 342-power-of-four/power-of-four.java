class Solution {
    public boolean isPowerOfFour(int n) {
    if(n == 1){
            return true;
        }
        if(n % 4 != 0){
            return false;
        }
        return powerOfFour(n,1);
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
