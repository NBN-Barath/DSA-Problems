// User function Template for Java

class Solution {
    static int searchInsertK(int arr[], int n, int k) {
        // code here
        int low = 0, high = n - 1, ans = n;
         while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }
}