class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    //     Arrays.sort(piles);
    //     int low = 1, high = piles[piles.length - 1];
    //     while(low <= high){
    //         int mid = (low + high)/2;
    //         int minHours = 
    //         if()
    //     }
    // }

    // public static int calculateTotalHours(int[] piles, int hourly) {
    //     int totalHour = 0;
    //     int n = piles.length;
    //     for (int i = 0; i < n; i++) {
    //         totalH += Math.ceil((double)(piles[i]) / (double)(hourly));
    //     }
    //     return totalHour;
    // }
    if(piles.length>h)
    {
        return 0;
    }
    int left =1;
    int right = -1;
    for(int i=0;i<piles.length;i++)
    {
        right =  Math.max(right,piles[i]);
    }
    int ans =0;
    while(left<=right)
    {
        int mid = (left+right)/2;
        int time =0;
        for(int i=0;i<piles.length;i++)
        {
            time+=Math.ceil((double)(piles[i])/mid);
        }
        if(time>h)
        {
            left = mid+1;
        }else{
            ans = mid;
            right = mid-1;
        }
    }
    return ans ;
}
}