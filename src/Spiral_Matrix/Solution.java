package Spiral_Matrix;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        int m = matrix.length, n = matrix[0].length;
        int[] ans = new int[m * n];
        int i = 0;

        while(left <= right && up <= down) {
            int x = up, y = left;
            // up margin
            while(y <= right && left <= right && up <= down) {
                ans[i] = matrix[x][y];
                i++;
                y++;
            }
            up++;

            // right margin
            x = up; y = right;
            while(x <= down && left <= right && up <= down) {
                ans[i] = matrix[x][y];
                i++;
                x++;
            }
            right--;

            // down margin
            x = down; y = right;
            while(y >= left && left <= right && up <= down) {
                ans[i] = matrix[x][y];
                i++;
                y--;
            }
            down--;

            // left margin
            x = down; y = left;
            while(x >= up && left <= right && up <= down) {
                ans[i] = matrix[x][y];
                i++;
                x--;
            }
            left++;
        }

        return ans;
    }
}
