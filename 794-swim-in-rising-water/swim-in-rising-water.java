class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int t = Math.max(grid[0][0], grid[n-1][n-1]); 
        while (true) {                      
            if (canReach(grid, t, n)) {     
                return t;
            }
            t++;                           
        }
    }

    private boolean canReach(int[][] grid, int t, int n) {
        if (grid[0][0] > t) return false;  

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            if (r == n - 1 && c == n - 1) return true; 

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
                    !visited[nr][nc] && grid[nr][nc] <= t) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
