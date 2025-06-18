// User function Template for Java

class Solution {
    public static int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }
    public int rowWithMax1s(int arr[][]) {
        // code here
        int c_max = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            int c_one = arr[i].length - lowerBound(arr[i], arr[i].length, 1);
            if (c_one > c_max) {
                c_max = c_one;
                index = i;
            }
        }
        return index;
        
    }
}