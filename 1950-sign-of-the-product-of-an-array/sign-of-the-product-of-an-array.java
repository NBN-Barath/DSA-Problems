class Solution {
    public int arraySign(int[] nums) {
        int negativeCount = 0;
        for (int a : nums) {
            if (a == 0) return 0; 
            if (a < 0) negativeCount++;
        }
        return (negativeCount % 2 == 0) ? 1 : -1;
    }
}
