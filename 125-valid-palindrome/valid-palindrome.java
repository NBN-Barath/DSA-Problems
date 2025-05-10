class Solution {
    public static boolean isPalindrome(String s) {
        if (s.equals("")) {
            return true;
        }

        s = s.toLowerCase().replaceAll("[^a-z0-9]", ""); 
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
        