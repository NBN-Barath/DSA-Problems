import java.util.HashMap;

class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer> hash = new HashMap<>();
        for(char c : s.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int freq : hash.values()) {
            if(freq % 2 == 0){
                min = Math.min(min, freq);
            }else{
                max = Math.max(max, freq);
            }
        }

        return max - min;
    }
}