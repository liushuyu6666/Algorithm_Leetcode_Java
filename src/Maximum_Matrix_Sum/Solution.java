package Maximum_Matrix_Sum;

public class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int cnt = 0, minAbs = Integer.MAX_VALUE;
        long sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                minAbs = Math.min(minAbs, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0) {
                    cnt++;
                }
            }
        }

        if(cnt % 2 == 0) {
            return sum;
        } else {
            return sum - (2 * minAbs);
        }
    }
}
