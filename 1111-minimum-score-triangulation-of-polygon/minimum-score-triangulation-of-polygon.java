class Solution {
    public int minScoreTriangulation(int[] v) {
        int n = v.length;
        int[][] arr = new int[n][n];
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                arr[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    arr[i][j] = Math.min(
                        arr[i][j],
                        arr[i][k] + arr[k][j] + v[i] * v[k] * v[j]
                    );
                }
            }
        }
        return arr[0][n - 1];
    }
}
