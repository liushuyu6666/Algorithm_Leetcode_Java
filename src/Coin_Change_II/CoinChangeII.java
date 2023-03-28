package Coin_Change_II;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp1 = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp1[i] = 0;
        }
        dp1[0] = 1;

        for (int i = 1; i < coins.length + 1; i++) {
            int[] dp2 = new int[amount + 1];
            dp2[0] = 1;
            int currCoin = coins[i - 1];
            for (int j = 1; j < amount + 1; j++) {
                dp2[j] = dp1[j]; // when there is no coin[i - 1] in my wallet
                if (j >= currCoin) {
                    dp2[j] += dp2[j - currCoin];
                }
            }
            dp1 = dp2;
        }

        return dp1[amount];
    }
}
