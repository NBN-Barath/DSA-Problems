class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n ;
        rev(nums,0,n-1);
        rev(nums,0,k-1);
        rev(nums,k,n-1);
        
    }
    public void rev(int[]arr, int start,int end) {
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }        
    }
}


