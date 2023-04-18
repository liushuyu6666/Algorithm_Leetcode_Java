package Pow_x_n;

public class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE) {
            double temp = dfs(x, Integer.MAX_VALUE);
            temp = temp * x;
            return 1 / temp;
        } else if (n < 0) {
            double temp = dfs(x, -n);
            return 1 / temp;
        } else {
            return dfs(x, n);
        }
    }

    public double dfs(double x, int n) {
        if(n == 0) return 1;
        double ans = 1;
        if((n & 0x1) == 1) {
            ans = x;
        }
        n = n >> 1;
        double temp = dfs(x, n);
        return temp * temp * ans;
    }
}
