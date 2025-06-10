class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int total =0;
        int max =0;
        for(int i=0;i<weights.length;i++)
        {
            total+=weights[i];
            max = Math.max(weights[i],max);
        }
        int left = max;
        int right = total;
        int ans =0;
        while(left<=right)
        {
            int mid = (left+right)/2;
            int numday = cal(weights,mid);
            if(numday>days)
            {
                left=mid+1;
            }else{
                ans = mid;
                right = mid-1;
            }
        }
        return ans ;
    }
    public int cal (int[]arr,int mid)
    {
        int curr = 0;
        int day =1;
        for(int i=0;i<arr.length;i++)
        {
            curr+=arr[i];
            if(curr>mid)
            {
                day++;
                curr=arr[i];
            }
        }
        return day;
    }
}