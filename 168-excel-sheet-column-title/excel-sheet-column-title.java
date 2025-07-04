class Solution {
    public String convertToTitle(int columnNumber) {
        String result = "";
        while (columnNumber > 0) {
            columnNumber--; 
            int remainder = columnNumber % 26;
            char ch = (char) (remainder + 'A');
            result = ch + result; 
            columnNumber /= 26;
        }
        return result;
    }
}