class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i=0, j=n-1, mid=0;
        while(mid<=j){
            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid] = nums[i];
                nums[i] = temp;
                i++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[j];
                nums[j] = nums[mid];
                nums[mid] = temp;
                j--;
            }
        }
    }
}