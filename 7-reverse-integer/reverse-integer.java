class Solution {
    public int reverse(int x) {
        long rev = 0;
        int rem;
        while (x != 0) {
            rem = x % 10;
            rev = (rev * 10) + rem;
            x = x / 10;
        }
        return (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) ? 0 : (int) rev;
    }
}