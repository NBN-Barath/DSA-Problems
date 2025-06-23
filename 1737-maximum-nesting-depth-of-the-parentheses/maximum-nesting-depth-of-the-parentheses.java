class Solution {
    public int maxDepth(String s) {
        int open = 0;
        int max = Integer.MIN_VALUE;
        for(char a : s.toCharArray()){
            if(a == '('){
                open++;
                max = Math.max(open,max);
            } 
            if(a == ')') open--;
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}