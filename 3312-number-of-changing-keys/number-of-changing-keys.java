class Solution {
    public int countKeyChanges(String s) {
        char[] c = s.toCharArray();
        int change = 0;
        for(int i = 1; i < c.length ; i++){
            if(Character.toLowerCase(c[i - 1] ) != Character.toLowerCase(c[i] )){
                change++;
            }
        } 
        return change;  
    }
}