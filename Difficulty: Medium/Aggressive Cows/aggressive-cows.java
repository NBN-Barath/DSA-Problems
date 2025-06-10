// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int low = 0, high = stalls[stalls.length -1 ] - stalls[0];
        int result = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(isCowAssigned(stalls,mid,k)){
                result = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return result;
    }
    public static boolean isCowAssigned(int[] stalls,int minDistance,int k){
        int cows = 1,lastPoint = stalls[0];
        for(int i = 0; i < stalls.length; i++){
            if(stalls[i] - lastPoint >=  minDistance){
                lastPoint = stalls[i];
                cows++;
            }
            if(cows >= k){
                return true;
            }
        }
        return false;
    }
}