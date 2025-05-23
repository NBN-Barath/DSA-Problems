// User function Template for Java

class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        // code here
       int maxSum = 0, currentSum = 0;
        int maxStart = 0, maxEnd = -1;
        int currentStart = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                currentSum += arr[i];

                if (currentSum > maxSum || (currentSum == maxSum && (i - currentStart > maxEnd - maxStart))) {
                    maxSum = currentSum;
                    maxStart = currentStart;
                    maxEnd = i;
                }
            } else {
                currentSum = 0;
                currentStart = i + 1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (maxEnd == -1) {
            list.add(-1);  
            return list;
        }
        for(int j = maxStart; j <= maxEnd; j ++){
                list.add(arr[j]);
            }
            
            return list;
    }
}