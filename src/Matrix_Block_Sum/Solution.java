package Matrix_Block_Sum;

public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];

        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int ax = Math.max(-1, i - k - 1);
                int bx = Math.min(m - 1, i + k);
                int ay = Math.max(-1, j - k - 1);
                int by = Math.min(n - 1, j + k);
                mat[i][j] = prefix[bx + 1][by + 1] - prefix[ax + 1][by + 1] - prefix[bx + 1][ay + 1] + prefix[ax + 1][ay + 1];
            }
        }

        return mat;
    }
}
