// class Solution {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         int sum = 0;
//         for(int i = 0; i < nums.length; i ++){
//             if(nums[i] != i){
//                 return i;
//             }
//         }
//         return nums.length;
//     }
// }

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int actual = n * (n + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return actual - sum;
    }
}
