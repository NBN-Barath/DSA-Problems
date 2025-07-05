class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int num : arr){
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        int maxLucky = -1;
        for (int n : hash.keySet()) {
            if (n == hash.get(n)) {
                maxLucky = Math.max(maxLucky, n);
            }
        }
        return maxLucky;
    }
}