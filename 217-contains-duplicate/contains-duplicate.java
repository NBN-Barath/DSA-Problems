class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            hash.add(nums[i]);
        }
        if(hash.size() == nums.length){
            return false;
        }
        return true;
    }
}