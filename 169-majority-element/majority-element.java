class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    max = nums[i];
                    count = 1;
                }
            }
        }
        return max;
    }
}