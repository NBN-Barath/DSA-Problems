class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1)    return; 
        int zero = -1;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == 0){
                zero = i;
                break; 
            }
        }
        if(zero == -1){
            return;
        }
        for(int i = zero + 1; i < nums.length ; i++){
            if(nums[i] != 0){
                nums[zero] = nums[i];
                nums[i] = 0;
                zero++;
            }
        }
    }
}
