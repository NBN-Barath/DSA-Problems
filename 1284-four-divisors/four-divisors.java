class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            int sum = 1 + num; 
            int count = 2;  
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    int j = num / i;
                    if (i == j) { 
                        count++; 
                        sum += i;
                    } else {
                        count += 2;
                        sum += i + j;
                    }
                    if (count > 4) break;
                }
            }
            if (count == 4) {
                totalSum += sum;
            }
        }
        return totalSum;
    }
}
