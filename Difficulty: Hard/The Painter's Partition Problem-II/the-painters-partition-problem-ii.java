// User function Template for Java

class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int low = getMax(arr),high = getSum(arr);
        while(low <= high){
            int mid = low + (high - low) / 2;
            int m = split(arr , mid);
            if(m > k){
                low = mid + 1;
            } else{
                high = mid - 1; 
            }
        }
        return low;
    }
    
    public static int getMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
    
     public static int getSum(int[] arr){
         int sum = 0;
         for(int num : arr){
             sum += num;
         }
         return sum;
     }
     
     public static int split(int[] arr, int mid){
         int s = 1;
         long tot = 0;
         for(int i = 0; i < arr.length ; i++){
             if(tot + arr[i] <= mid){
                 tot += arr[i];
             } else{
                 s++;
                 tot = arr[i];
             }
         }
         return s;
     }
}