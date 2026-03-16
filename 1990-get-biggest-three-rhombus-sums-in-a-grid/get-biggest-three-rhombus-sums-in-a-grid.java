class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                set.add(grid[i][j]);

                for (int k = 1; ; k++) {

                    int r = i + 2 * k;
                    int left = j - k;
                    int right = j + k;

                    if (r >= m || left < 0 || right >= n) break;

                    int sum = 0;
                    int x = i, y = j;

                    for (int t = 0; t < k; t++)
                        sum += grid[x + t][y + t];

                    for (int t = 0; t < k; t++)
                        sum += grid[x + k + t][y + k - t];

                    for (int t = 0; t < k; t++)
                        sum += grid[x + 2 * k - t][y - t];

                    for (int t = 0; t < k; t++)
                        sum += grid[x + k - t][y - k + t];

                    set.add(sum);
                }
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        int size = Math.min(3, list.size());
        int[] ans = new int[size];

        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}