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
                /**
                 * (i, j) is under the mat coordinates, regardless of the boundary, we have
                 * int ax = i - k - 1, bx = i + k;
                 * int ay = j - k - 1, by = j + k;
                 * In general, regardless of the boundary,
                 * we need ans(i, j) = Pf(bx, by) - Pf(ax, by) - Pf(bx, ay) + Pf(ax, ay), where Pf(x, y) is the prefix sum of the (x, y) in the mat.
                 * We already know Pf(x, y) = prefix(x + 1, y + 1);
                 * Then we have ans(i, j) = prefix(bx + 1, by + 1) - prefix(ax + 1, by + 1) - prefix(bx + 1, ay + 1) + prefix(ax + 1, ay + 1)
                 *   ax + 1 >= 0      =>    ax >= -1;
                 *   bx + 1 < m + 1   =>    bx < m;
                 *   ay + 1 >= 0      =>    ay >= -1;
                 *   by + 1 < n + 1   =>    by < n;
                 */
                int ax = Math.max(-1, i - k - 1);
                int bx = Math.min(m - 1, i + k);
                int ay = Math.max(-1, j - k - 1);
                int by = Math.min(n - 1, j + k);
                mat[i][j] = prefix[bx + 1][ by + 1] - prefix[ax + 1][ by + 1] - prefix[bx + 1][ ay + 1] + prefix[ax + 1][ ay + 1];
            }
        }

        return mat;
    }
}
