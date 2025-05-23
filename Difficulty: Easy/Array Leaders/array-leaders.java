class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int leader = arr[arr.length - 1];
        ArrayList<Integer> num = new ArrayList<>();
        num.add(leader);
        for(int i = arr.length - 2; i >= 0 ; i--){
            if(arr[i] >= leader){
                leader = arr[i];
                num.add(0,leader);
            }
        }
        return num;
    }
}
