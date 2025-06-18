class Solution {
     static final int MOD = 1_000_000_007;
    static long power(long base, int exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    static long combination(int n, int r) {
        if (r > n) return 0;
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i) % MOD;
            res = res * power(i + 1, MOD - 2) % MOD; 
        }
        return res;
    }

    public static int countGoodArrays(int n, int m, int k) {
        long ans = m;
        ans = (ans * combination(n - 1, k)) % MOD;
        ans = (ans * power(m - 1, n - 1 - k)) % MOD;
        return (int) ans;
    }
}