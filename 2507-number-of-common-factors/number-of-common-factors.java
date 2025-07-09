class Solution {
    public int commonFactors(int a, int b) {
        int gcd = findGCD(a, b);
        int count = 0;
        
        for (int i = 1; i * i <= gcd; i++) {
            if (gcd % i == 0) {
                count++;
                if (i != gcd / i) count++;
            }
        }
        return count;
    }

    private int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }
}
