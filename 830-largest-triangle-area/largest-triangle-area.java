class Solution {
    public double largestTriangleArea(int[][] points) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < points.length - 2; i++) {
            int j = i + 1, k = points.length - 1;
            while (j<points.length-1) {
                int x1 = points[i][0], x2 = points[j][0],x3 = points[k][0];
                int y1 = points[i][1], y2 = points[j][1],y3 = points[k][1];
                double area = 0.5 * Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
                max = Math.max(area, max);
                k--;
                if(k == j){
                    k = points.length-1;
                    j+=1;
                }
            }

        }
        return max;
    }
}