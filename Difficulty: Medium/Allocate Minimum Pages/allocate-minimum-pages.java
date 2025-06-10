
//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if(k > arr.length){
            return -1;
        }
        if(k == 1){
            return getSum(arr);
        }
        
        int low = getMax(arr),high = getSum(arr);
        while(low <= high){
            int mid = low + (high - low) / 2;
            int noOfStud = countStud(arr , mid);
            if(noOfStud > k){
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
     
     public static int countStud(int[] arr, int page){
         int stud = 1;
         long pagesPerStud = 0;
         for(int i = 0; i < arr.length ; i++){
             if(pagesPerStud + arr[i] <= page){
                 pagesPerStud += arr[i];
             } else{
                 stud++;
                 pagesPerStud = arr[i];
             }
         }
         return stud;
     }
}