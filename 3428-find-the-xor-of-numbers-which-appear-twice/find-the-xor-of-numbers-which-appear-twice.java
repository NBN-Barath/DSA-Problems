class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        int a = 0; 
        for(int i : map.keySet()){
            if(map.get(i) == 2){
                a = a ^ i;
            }
        }
        return a;
    }
}