// User function Template for Java

import java.util.List;

class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int n = arr.size();
        int low = 0, high = n - 1 , ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr.get(low) <= arr.get(mid)){
                ans = Math.min(ans,arr.get(low));
                low = mid + 1;
            }else {
                ans = Math.min(ans,arr.get(mid));
                high = mid - 1;
            }
        }
        return arr.indexOf(ans);
    }
}