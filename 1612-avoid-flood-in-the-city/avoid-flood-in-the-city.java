class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> lakeLastRain = new HashMap<>(); 
        List<Integer> dryDays = new ArrayList<>();            
        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {         
                ans[i] = -1;             
                int lake = rains[i];
                if (lakeLastRain.containsKey(lake)) {
                    int last = lakeLastRain.get(lake);
                    int dryIndex = -1;
                    for (int idx = 0; idx < dryDays.size(); idx++) {
                        if (dryDays.get(idx) > last) {
                            dryIndex = dryDays.get(idx);
                            dryDays.remove(idx);
                            break;
                        }
                    }
                    if (dryIndex == -1) {
                        return new int[0];
                    }
                    ans[dryIndex] = lake;   
                }
                lakeLastRain.put(lake, i);   
            } 
            else {                           
                ans[i] = 1;                   
                dryDays.add(i);               
            }
        }
        return ans;
    }
}
