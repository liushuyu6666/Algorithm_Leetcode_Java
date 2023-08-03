package Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length; // 3
        int n = matrix[0].length; // 4

        int leftTop_x = 0, leftTop_y = 0, rightBottom_x = m - 1, rightBottom_y = n - 1;

        while(leftTop_x <= rightBottom_x && leftTop_y <= rightBottom_y) {
            if(leftTop_x <= rightBottom_x && leftTop_y <= rightBottom_y) {
                // leftTop: [1, 1]; rightBottom: [1, 2];
                List<Integer> newList = listTop(matrix, leftTop_x, leftTop_y, rightBottom_x, rightBottom_y);
                ans = Stream.concat(ans.stream(), newList.stream()).toList();
                leftTop_x++; // 2
            }
            if(leftTop_x <= rightBottom_x && leftTop_y <= rightBottom_y) {
                // leftTop: [1, 0]; rightBottom: [2, 3];
                List<Integer> newList = listRight(matrix, leftTop_x, leftTop_y, rightBottom_x, rightBottom_y);
                ans = Stream.concat(ans.stream(), newList.stream()).toList();
                rightBottom_y--; // 2
            }
            if(leftTop_x <= rightBottom_x && leftTop_y <= rightBottom_y) {
                // leftTop: [1, 0]; rightBottom: [2, 2];
                List<Integer> newList = listBottom(matrix, leftTop_x, leftTop_y, rightBottom_x, rightBottom_y);
                ans = Stream.concat(ans.stream(), newList.stream()).toList();
                rightBottom_x--; // 1
            }
            if(leftTop_x <= rightBottom_x && leftTop_y <= rightBottom_y) {
                // leftTop: [1, 0]; rightBottom: [1, 2];
                List<Integer> newList = listLeft(matrix, leftTop_x, leftTop_y, rightBottom_x, rightBottom_y);
                ans = Stream.concat(ans.stream(), newList.stream()).toList();
                leftTop_y++; // 1
            }

        }

        return ans;
    }

    public List<Integer> listTop(int[][] matrix, int leftTop_x, int leftTop_y, int rightBottom_x, int rightBottom_y) {
        List<Integer> ans = new ArrayList<>();
        // [1, 2]
        for(int i = leftTop_y; i <= rightBottom_y; i++) {
            ans.add(matrix[leftTop_x][i]); // (1, i)
        }

        return ans;
    }

    public List<Integer> listBottom(int[][] matrix, int leftTop_x, int leftTop_y, int rightBottom_x, int rightBottom_y) {
        List<Integer> ans = new ArrayList<>();
        // [2, 0]
        for(int i = rightBottom_y; i >= leftTop_y; i--) {
            ans.add(matrix[rightBottom_x][i]); // 2
        }

        return ans;
    }

    public List<Integer> listRight(int[][] matrix, int leftTop_x, int leftTop_y, int rightBottom_x, int rightBottom_y) {
        List<Integer> ans = new ArrayList<>();
        // [1, 2]
        for(int i = leftTop_x; i <= rightBottom_x; i++) {
            ans.add(matrix[i][rightBottom_y]); // (i, 3)
        }

        return ans;
    }

    public List<Integer> listLeft(int[][] matrix, int leftTop_x, int leftTop_y, int rightBottom_x, int rightBottom_y) {
        List<Integer> ans = new ArrayList<>();
        // [1, 1]
        for(int i = rightBottom_x; i >= leftTop_x; i--) {
            ans.add(matrix[i][leftTop_y]); // (i, 0)
        }

        return ans;
    }
}
