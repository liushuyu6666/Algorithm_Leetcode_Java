package Zero_One_Matrix;

import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        boolean[][] charted = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                charted[i][j] = false;
                if(mat[i][j] == 0) {
                    charted[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] coordinate = queue.poll(); // get the current coordinate.
            int x = coordinate[0], y = coordinate[1]; // get the current (x, y).
            int currDist = mat[x][y]; // get the distance of the current grid

            for(int d = 0; d < 4; d++) {
                int[] direction = directions[d];
                int newX = x + direction[0], newY = y + direction[1];
                if(newX >= 0 && newX < m && newY >= 0 && newY < n && !charted[newX][newY]) {
                    charted[newX][newY] = true;
                    mat[newX][newY] = currDist + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return mat;
    }
}
