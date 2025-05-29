class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long total = 0;
        int left = 0, maxFreq = 0;
        for (int right = 0; right < nums.length; right++) {
            total += (long) nums[right];
            while ((long)(right - left + 1) * nums[right] - total > k) {
                total -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}