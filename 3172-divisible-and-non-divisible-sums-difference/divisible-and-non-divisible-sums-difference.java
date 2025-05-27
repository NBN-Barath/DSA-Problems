class Solution {
    public int differenceOfSums(int n, int m) {
        int divsable = 0;
        int nonDivisable = 0;
        for(int i = 1 ; i <= n ; i++){
            if(i % m == 0){
                divsable += i;
            } else{
                nonDivisable += i;
            }
        }
        return nonDivisable - divsable;
    }
}