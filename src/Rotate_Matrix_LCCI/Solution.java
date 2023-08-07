package Rotate_Matrix_LCCI;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int start = 0, end = n - 2 - start;
        int temp;

        while(start <= end) {
            for(int i = start; i <= end; i++) {
                temp = matrix[start][i];
                matrix[start][i] = matrix[n - 1 - i][start];
                matrix[n - 1 - i][start] = matrix[n - 1 - start][n - 1 - i];
                matrix[n - 1 - start][n - 1 - i] = matrix[i][n - 1 - start];
                matrix[i][n - 1 - start] = temp;
            }
            start++;
            end--;
        }
    }
}
