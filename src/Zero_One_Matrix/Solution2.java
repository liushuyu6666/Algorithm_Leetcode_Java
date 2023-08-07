package Zero_One_Matrix;

public class Solution2 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] distances = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    distances[i][j] = 0;
                } else {
                    distances[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }

        // Only one row
        if(m == 1) {
            // From left to right
            for(int j = 1; j < n; j++) {
                distances[0][j] = Math.min(distances[0][j], distances[0][j - 1] + 1);
            }

            // From right to left
            for(int j = n - 2; j >= 0; j--) {
                distances[0][j] = Math.min(distances[0][j], distances[0][j + 1] + 1);
            }

            return distances;
        }

        // Only one column
        if(n == 1) {
            // From top to bottom
            for(int i = 1; i < m; i++) {
                distances[i][0] = Math.min(distances[i][0], distances[i - 1][0] + 1);
            }

            // From bottom to top
            for(int i = m - 2; i >= 0; i--) {
                distances[i][0] = Math.min(distances[i][0], distances[i + 1][0] + 1);
            }

            return distances;
        }

        // Left top to right bottom
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                distances[i][j] = Math.min(distances[i][j], Math.min(distances[i][j - 1], distances[i - 1][j]) + 1);
            }
        }

        // Right top to left bottom
        for(int i = 1; i < m; i++) {
            for(int j = n - 2; j >= 0; j--) {
                distances[i][j] = Math.min(distances[i][j], Math.min(distances[i][j + 1], distances[i - 1][j]) + 1);
            }
        }

        // Left bottom to right top
        for(int i = m - 2; i >= 0; i--) {
            for(int j = 1; j < n; j++) {
                distances[i][j] = Math.min(distances[i][j], Math.min(distances[i][j - 1], distances[i + 1][j]) + 1);
            }
        }

        // Right bottom to left top
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                distances[i][j] = Math.min(distances[i][j], Math.min(distances[i][j + 1], distances[i + 1][j]) + 1);
            }
        }

        return distances;
    }
}
