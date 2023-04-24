package Last_Remaining_Number_in_Circle;

public class Solution {
    public int lastRemaining(int n, int m) {
        return dfs(n, m);
    }
    public int dfs(int n, int m) {
        if(n == 1) return 0;
        return (this.dfs(n - 1, m) + m) % n;
    }
}
