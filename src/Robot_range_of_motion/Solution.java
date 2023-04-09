package Robot_range_of_motion;

public class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] isOccupied = new boolean[m][n];
        return dfs(isOccupied, 0, 0, m, n, k);
    }

    public int dfs(boolean[][] isOccupied, int x, int y, int m, int n, int k) {
        if(x < 0 || x >= m || y < 0 || y >= n) return 0;
        if(isOccupied[x][y]) return 0;
        if(!canArrive(x, y, k)) return 0;
        isOccupied[x][y] = true;
        return 1 + dfs(isOccupied, x + 1, y, m, n, k) +
                dfs(isOccupied, x - 1, y, m, n, k) +
                dfs(isOccupied, x, y + 1, m, n, k) +
                dfs(isOccupied, x, y - 1, m, n, k);
    }

    public boolean canArrive(int x, int y, int k) {
        String xStr = Integer.toString(x);
        String yStr = Integer.toString(y);
        int sum = 0;
        for(int i = 0; i < xStr.length(); i++) {
            sum += Integer.parseInt(xStr.substring(i, i + 1));
        }
        for(int j = 0; j < yStr.length(); j++) {
            sum += Integer.parseInt(yStr.substring(j, j + 1));
        }
        return sum <= k;
    }
}
