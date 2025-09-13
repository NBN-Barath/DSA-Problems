class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character , Integer > hash = new HashMap<>();
        int v = 0, c = 0;
        for(char x : s.toCharArray()){
            hash.put(x,hash.getOrDefault(x,0)+1);
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' || x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U'){
                v = Math.max(v,hash.get(x));
            }else{
                c = Math.max(c,hash.get(x));
            }
        }
        return v + c;
    }
}