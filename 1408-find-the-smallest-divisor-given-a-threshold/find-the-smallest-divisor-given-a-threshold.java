class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int low = 1, high = nums[nums.length - 1];
        while(low <= high){
            int mid = (low + high)/2;
            int sum = 0;
            for(int i : nums){
                sum += Math.ceil((double) (i)/mid); 
            }
            if(sum <= threshold){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}