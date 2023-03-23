package Wildcard_Matching;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();

        // Initialize dp1
        boolean[] dp1 = new boolean[sLen + 1];
        dp1[0] = true;
        for (int i = 1; i < sLen + 1; i++) {
            dp1[i] = false;
        }

        boolean value;
        for (int j = 1; j < pLen + 1; j++) {
            boolean[] dp2 = new boolean[sLen + 1];
            if (p.charAt(j - 1) == '*') dp2[0] = dp1[0]; // Initialize
            else dp2[0] = false;
            value = dp1[0];
            for (int i = 1; i < sLen + 1; i++) {
                value |= dp1[i];
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp2[i] = dp1[i - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp2[i] = value;
                } else {
                    dp2[i] = false;
                }
            }
            dp1 = dp2;
        }

        return dp1[sLen];
    }
}
