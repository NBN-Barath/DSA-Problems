class Solution {
    public String firstPalindrome(String[] words) {
        for(String str : words){
            char[] s = str.toCharArray();
            int start = 0;
            boolean c = true;
            for(int i = s.length - 1; i >= (s.length - 1)/2 ; i--){
                if(s[i] != s[start]){
                    c = false;
                    break;
                }
                start++ ;
            }
            if(c == true){
                return str;
            }
        }
        return "";
    }
}