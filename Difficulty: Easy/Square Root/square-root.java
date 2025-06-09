/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    int floorSqrt(int n) {
        // Your code here
        int low = 1,high = n;
        while(low <= high){
            int mid = (low + high)/2;
            if(mid * mid == n){
                return mid;
            }
            if(mid * mid > n){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
}