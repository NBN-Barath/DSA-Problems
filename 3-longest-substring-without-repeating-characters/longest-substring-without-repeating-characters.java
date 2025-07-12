import java.util.ArrayList;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> list = new ArrayList<>();
        int maxcount = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (list.contains(ch)) {
                if (count > maxcount) {
                    maxcount = count;
                }
                while (list.contains(ch)) {
                    list.remove(0);
                    count--;
                }
            }

            list.add(ch);
            count++;
        }
        if (count > maxcount) {
            maxcount = count;
        }

        return maxcount;
    }
}
