class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';

                int mul = d1 * d2;
                int posLow = i + j + 1;
                int posHigh = i + j;

                int sum = mul + result[posLow];
                result[posLow] = sum % 10;
                result[posHigh] += sum / 10;
            }
        }

        String resultStr = "";
        boolean leadingZero = true;

        for (int num : result) {
            if (leadingZero && num == 0) {
                continue; 
            } else {
                leadingZero = false;
                resultStr += (char) (num + '0');
            }
        }
        return resultStr.equals("") ? "0" : resultStr;
    }
}
