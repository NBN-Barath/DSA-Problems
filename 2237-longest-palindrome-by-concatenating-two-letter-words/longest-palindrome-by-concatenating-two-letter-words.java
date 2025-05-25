class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> freq = new HashMap<>();
        int length = 0;
        boolean middleUsed = false;
        for (String word : words) {
            if (freq.containsKey(word)) {
                freq.put(word, freq.get(word) + 1);
            } else {
                freq.put(word, 1);
            }
        }
        for (String w : freq.keySet()) {
            String rev = new StringBuilder(w).reverse().toString();

            if (!w.equals(rev)) {
                if (freq.containsKey(rev)) {
                    int pairs = Math.min(freq.get(w), freq.get(rev));
                    length += pairs * 4;
                    freq.put(w, freq.get(w) - pairs);
                    freq.put(rev, freq.get(rev) - pairs);
                }
            }
        }
        for (String w : freq.keySet()) {
            if (w.charAt(0) == w.charAt(1)) {
                int count = freq.get(w);
                length += (count / 2) * 4;
                if (count % 2 == 1) {
                    middleUsed = true;
                }
            }
        }

        if (middleUsed) {
            length += 2;
        }

        return length;
    }
}