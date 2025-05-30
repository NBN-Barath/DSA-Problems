class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int xr = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0 ; i < arr.length ; i++){
            xr = xr ^ arr[i];
            int n = xr ^ k;
            if(map.containsKey(n)){
                count += map.get(n);
            }
            map.put(xr, map.getOrDefault(xr,0) + 1);
            
        }
        return count;
    }
}