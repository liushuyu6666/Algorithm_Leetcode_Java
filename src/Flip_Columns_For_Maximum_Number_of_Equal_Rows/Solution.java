package Flip_Columns_For_Maximum_Number_of_Equal_Rows;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb;
        for (int[] ints : matrix) {
            sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (ints[0] == 1) {
                    sb.append((ints[j] + 1) % 2);
                } else {
                    sb.append(ints[j]);
                }
            }
            Integer cnt = map.getOrDefault(sb.toString(), 0);
            map.put(sb.toString(), cnt + 1);
        }

        int maxRows = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxRows = Math.max(maxRows, entry.getValue());
        }
        return maxRows;
    }
}
