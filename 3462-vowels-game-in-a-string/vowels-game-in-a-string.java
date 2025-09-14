class Solution {
    public boolean doesAliceWin(String s) {
        int v = 0;
        boolean b = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                v++;
            }
        }

        if (v > 0) b = true;
        return b;
    }
}
