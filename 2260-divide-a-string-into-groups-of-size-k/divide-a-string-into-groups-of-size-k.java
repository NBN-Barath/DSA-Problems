class Solution {
    public String[] divideString(String s, int k, char fill) {
        ArrayList<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int end = Math.min(i + k, s.length());
            String group = s.substring(i, end);
            if (group.length() < k) {
                int remaining = k - group.length();
                for (int j = 0; j < remaining; j++) {
                    group += fill;
                }
            }
            result.add(group);
            i += k;
        }

        return result.toArray(new String[0]);
    }
}