class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        int n1 = a.length, n2 = b.length;
        
        // Ensure a is the smaller array
        if (n1 > n2) return kthElement(b, a, k);
        
        int low = Math.max(0, k - n2), high = Math.min(k, n1);
        
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : a[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : b[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return -1; 
    }
}
