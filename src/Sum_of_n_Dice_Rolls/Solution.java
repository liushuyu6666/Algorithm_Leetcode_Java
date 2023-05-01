package Sum_of_n_Dice_Rolls;

public class Solution {
    public double[] dicesProbability(int n) {
        int[] dp1 = new int[]{1, 1, 1, 1, 1, 1};

        for(int i = 2; i <= n; i++) {
            int[] dp2 = new int[5 * i + 1];
            for(int startIdx = 0; startIdx < 6; startIdx++) {
                add(dp1, dp2, startIdx);
            }
            dp1 = dp2;
        }

        double[] ans = new double[dp1.length];
        for(int i = 0; i < dp1.length; i++) {
            ans[i] = (double)dp1[i] * Math.pow((double)1/6, n);
        }

        return ans;
    }

    public void add(int[] v1, int[] v2, int startIdx) {
        for(int i = 0; i < v1.length; i++) {
            v2[i + startIdx] += v1[i];
        }
    }
}
