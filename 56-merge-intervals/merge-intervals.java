class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length;

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int[][] ans = new int[n][2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (index == 0 || arr[i][0] > ans[index - 1][1]) {
                ans[index][0] = arr[i][0];
                ans[index][1] = arr[i][1];
                index++;
            } else {
                ans[index - 1][1] = Math.max(ans[index - 1][1], arr[i][1]);
            }
        }
        int[][] result = new int[index][2];
        for (int i = 0; i < index; i++) {
            result[i][0] = ans[i][0];
            result[i][1] = ans[i][1];
        }

        return result;
    }
}
