class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            long minPotion = (success + spell - 1) / spell; 
            int index = lowerBound(potions, minPotion);
            res[i] = n - index;  
        }
        return res;
    }
    private int lowerBound(int[] arr, long target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
