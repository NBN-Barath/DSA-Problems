class Solution {
    public int possibleStringCount(String word) {
        int count = 1;
        int index = 0;
        while(index < word.length() - 1){
            if(word.charAt(index + 1) == word.charAt(index)){
                count++;
            }
            index++;
        }
        return  count;
    }
}