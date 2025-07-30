class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            int j = target - nums[i];
            if(hash.containsKey(j)){
                return new int[] {hash.get(j), i};
            }
            hash.put(nums[i],i);
        }
        return new int[] {};
    }
}