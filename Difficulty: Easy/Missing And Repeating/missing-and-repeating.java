class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        long n = arr.length;
        long sum = (n * (n + 1)) / 2;
        long sum2 = (n * (n + 1) * (2 * n + 1)) / 6;
        long num1 = 0, num2 = 0;
        for (int i = 0; i < n; i++) {
            num1 += arr[i];
            num2 += (long) arr[i] * (long) arr[i];
        }
        long val1 = num1 - sum;
        long val2 = num2 - sum2;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add((int) x);
        list.add((int) y);
        return list;
    }

}
