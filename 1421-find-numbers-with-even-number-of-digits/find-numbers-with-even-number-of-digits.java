class Solution {
    public int findNumbers(int[] nums) {
        int tot = 0;
        for(int n : nums){
            int noDigit = 0;
            while(n > 0){
                n/=10;
                noDigit++;
            }
            if(noDigit % 2 == 0){
                tot++;
            }
        }
        return tot;
    }
}