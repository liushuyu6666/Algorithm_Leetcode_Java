package Minimum_Skips_to_Arrive_at_Meeting_On_Time;

public class Solution1 {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        double eps = 0.0000001;
        int x = dist.length;

        /** dp[i][j] represents the total minimum hours we spend when crossing the (i - 1)th road and having already skipped j times. */
        double[][] dp = new double[x][x];

        // Initialization
        for(int i = 1; i < x; i++) {
            for(int j = 0; j < x; j++) {
                dp[i][j] = 10000000;
            }
        }
        for(int i = 1; i < x; i++) {
            dp[i][0] = Math.ceil(dp[i - 1][0] + ((double)dist[i - 1] / speed) - eps);
        }

        for(int i = 1; i < x; i++) {
            for(int j = 1; j <= i; j++) {
                // skip the rest
                double skip = dp[i - 1][j - 1] + ((double)dist[i - 1] / speed);
                // hava a rest
                double rest = Math.ceil(dp[i - 1][j] + ((double)dist[i - 1] / speed) - eps);
                dp[i][j] = Math.min(skip, rest);
            }
        }

        double hoursInTheLast = ((double)dist[x - 1] / speed);
        double hoursBeforeTheLast = hoursBefore - hoursInTheLast;

        for(int j = 0; j < x; j++) {
            if(dp[x - 1][j] - eps <= hoursBeforeTheLast) {
                return j;
            }
        }
        return -1;
    }
}
