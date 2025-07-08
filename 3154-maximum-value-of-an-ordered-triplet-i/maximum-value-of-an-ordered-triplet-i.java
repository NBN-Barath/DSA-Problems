class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxValue = 0;

        for (int j = 1; j < n - 1; j++) {
            int maxLeft = nums[0];
            for (int i = 1; i < j; i++) {
                if (nums[i] > maxLeft) {
                    maxLeft = nums[i];
                }
            }

            for (int k = j + 1; k < n; k++) {
                long val = (long)(maxLeft - nums[j]) * nums[k];
                maxValue = Math.max(maxValue, val);
            }
        }
        return maxValue;
    }
}
