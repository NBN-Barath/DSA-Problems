class Cell {
    int row, col, height;
    Cell(int r, int c, int h) {
        row = r;
        col = c;
        height = h;
    }
}
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m <= 2 || n <= 2) return 0;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        int water = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] d : dirs) {
                int x = cell.row + d[0];
                int y = cell.col + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                visited[x][y] = true;
                if (heightMap[x][y] < cell.height) {
                    water += cell.height - heightMap[x][y];
                }
                pq.offer(new Cell(x, y, Math.max(heightMap[x][y], cell.height)));
            }
        }

        return water;
    }
}