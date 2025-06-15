public class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num); 

        char digitToChangeMax = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                digitToChangeMax = c;  
                break;
            }
        }
        String maxStr = s;
        if (digitToChangeMax != ' ') {
            maxStr = s.replace(digitToChangeMax, '9');  
        }

        char digitToChangeMin = ' ';
        String minStr = s;
        if (s.charAt(0) != '1') {
            digitToChangeMin = s.charAt(0);  
            minStr = s.replace(digitToChangeMin, '1');  
        } else {
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '0' && c != '1') {
                    digitToChangeMin = c;
                    minStr = s.replace(digitToChangeMin, '0');  
                    break;
                }
            }
        }

        int big = Integer.parseInt(maxStr);
        int small = Integer.parseInt(minStr);
        return big - small;
    }
}
