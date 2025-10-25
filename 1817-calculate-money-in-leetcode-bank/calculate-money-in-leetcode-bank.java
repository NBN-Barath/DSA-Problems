class Solution {
    public int totalMoney(int n) {
        int week = n / 7;      
        int days = n % 7;     
        int total = 0;       
        total += 7 * week * (week + 1) / 2;  
        total += 21 * week;                  
        for (int i = 1; i <= days; i++) {
            total += week + i;  
        }
        return total;
    }
}
