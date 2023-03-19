package Regular_Expression_Matching;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        // Initial Value: Padding
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 1; i < pLen + 1; i++) {
            if (p.charAt(i - 1) != '*') dp[0][i] = false;
            else dp[0][i] = dp[0][i - 2];
        }

        // Transition
        for (int i = 1; i < sLen + 1; i++) {
            dp[i][0] = false;
            for (int j = 1; j < pLen + 1; j++) {
                char currP = p.charAt(j - 1);
                char currS = s.charAt(i - 1);
                if (currS == currP || currP == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (currP == '*') {
                    char prevP = p.charAt(j - 2);
                    dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || (dp[i - 1][j - 1] && (prevP == '.'|| prevP == currS)) || (dp[i - 1][j] && (prevP == '.' || prevP == currS));
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[sLen][pLen];
    }

    public boolean isMatchFor1D(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        // Initial: Padding
        boolean[] dp1 = new boolean[pLen + 1];
        dp1[0] = true;
        for (int i = 1; i < pLen + 1; i++) {
            dp1[i] = p.charAt(i - 1) == '*' && dp1[i - 2];
        }

        for (int i = 1; i < sLen + 1; i++) {
            boolean[] dp2 = new boolean[pLen + 1];
            dp2[0] = false;
            boolean quickResult = false;
            for (int j = 1; j < pLen + 1; j++) {
                char currP = p.charAt(j - 1);
                char currS = s.charAt(i - 1);

                if (currP == '.' || currP == currS) dp2[j] = dp1[j - 1];
                else if (currP == '*') {
                    char prevP = p.charAt(j - 2);
                    dp2[j] = dp2[j - 2] || dp2[j - 1] || ((prevP == currS || prevP == '.') && dp1[j - 1]) || ((prevP == currS || prevP == '.') && dp1[j]);
                }
                else {
                    dp2[j] = false;
                }
                quickResult |= dp2[j];
            }
            if (!quickResult) return false;
            dp1 = dp2;
        }

        return dp1[pLen];
    }

    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        String s = "aab";
        String p = "c*a*b";

        boolean resultFor1D = rem.isMatchFor1D(s, p);
        System.out.println(resultFor1D);
    }
}
