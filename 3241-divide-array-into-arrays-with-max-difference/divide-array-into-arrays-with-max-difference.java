class Solution {
    public int[][] divideArray(int[] nums, int k) {
       Arrays.sort(nums); 
        int n = nums.length;
        int[][] result = new int[n / 3][3];
        int index = 0;
        for (int i = 0; i < n; i += 3) {
            int a = nums[i], b = nums[i + 1], c = nums[i + 2];
            if (c - a > k) return new int[0][0]; 
            result[index][0] = a;
            result[index][1] = b;
            result[index][2] = c;
            index++;
        }
        return result;  
    }
}