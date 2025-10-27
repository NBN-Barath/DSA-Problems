class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int prev = 0;
        for (String s : bank) {
            int curr = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') curr++;
            }
            if (curr > 0) {       
                res += prev * curr;
                prev = curr;
            }
        }
        return res;
    }
}
