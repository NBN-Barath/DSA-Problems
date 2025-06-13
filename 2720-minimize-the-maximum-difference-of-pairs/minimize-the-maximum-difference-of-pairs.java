class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int mid = (low + high) / 2;
            if (canPair(nums, p, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canPair(int[] nums, int p, int maxDiff) {
        int count = 0;
        for (int i = 1; i < nums.length && count < p; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i++; 
            }
        }
        return count >= p;
    }
}
