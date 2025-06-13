class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int a = nums.length;;
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(target <= nums[mid]){
                a = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return a;
    }
}