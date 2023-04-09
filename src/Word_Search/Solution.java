package Word_Search;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] isOccupied = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(board, isOccupied, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] isOccupied, int x, int y, String word, int wordIdx) {
        int m = board.length, n = board[0].length;
        if(wordIdx == word.length()) return true;
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        if(isOccupied[x][y]) return false;
        if(board[x][y] != word.charAt(wordIdx)) return false;
        isOccupied[x][y] = true;
        boolean finalResult =
                dfs(board, isOccupied, x + 1, y, word, wordIdx + 1) ||
                        dfs(board, isOccupied, x - 1, y, word, wordIdx + 1) ||
                        dfs(board, isOccupied, x, y + 1, word, wordIdx + 1) ||
                        dfs(board, isOccupied, x, y - 1, word, wordIdx + 1);
        isOccupied[x][y] = false;
        return finalResult;
    }
}
