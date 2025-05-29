class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int sufix = 1;
        int max = Integer.MIN_VALUE;
        for(int num = 0; num < nums.length ; num++){
            if(prefix == 0){
                prefix = 1;
            }
            if(sufix == 0){
                sufix = 1;
            }
            prefix *= nums[num];
            sufix *= nums[nums.length - num  - 1];
            max = Math.max((Math.max(prefix,max)),(Math.max(sufix,max)));
        }
        return max;
    }
}