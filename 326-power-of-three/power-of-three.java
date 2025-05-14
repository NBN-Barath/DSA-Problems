class Solution {
    public boolean isPowerOfThree(int n) {
    if(n == 1){
            return true;
        }
        if(n % 3 != 0){
            return false;
        }
        return powerOfThree(n,1);
    }
    public boolean powerOfThree(int n, int pow){
        if(Math.pow(3 , pow) == n){
            return true;
        }
        if(Math.pow(3 , pow) > n){
            return false;
        }
        return powerOfThree(n,pow + 1);
    }
}