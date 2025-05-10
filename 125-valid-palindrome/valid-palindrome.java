class Solution {
    public boolean isPalindrome(String s) {
        if (s.equals("")) {
                return true;
            }
            s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                    return false;
                }
            }
            return true;
    }
}
        