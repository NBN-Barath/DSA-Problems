public class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        char toReplaceMax = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        String maxStr = (toReplaceMax == ' ') ? s : s.replace(toReplaceMax, '9');
        char toReplaceMin = s.charAt(0);
        String minStr = s.replace(toReplaceMin, '0');
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}
