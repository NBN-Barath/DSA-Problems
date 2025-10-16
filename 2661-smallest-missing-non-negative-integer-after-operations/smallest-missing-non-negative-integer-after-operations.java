class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value];

        for (int num : nums) {
            int mod = ((num % value) + value) % value; 
            count[mod]++;
        }

        int x = 0;
        while (true) {
            int remainder = x % value;
            if (count[remainder] == 0) {
                return x;
            }
            count[remainder]--;
            x++;
        }
    }
}
