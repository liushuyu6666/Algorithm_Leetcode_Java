package Dynamic_Programming;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int longestLen = 1;
        String longestPalin = s.substring(0, 1);

        // dp[i][j]:
        // If true, means s_i ~ s_j is a palindrome.
        // If false, means s_i ~ s_j is not a palindrome.
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);

                // Record the string if it is the current longest palindrome.
                if (j - i + 1 >= longestLen && dp[i][j]) {
                    longestLen = j - i + 1;
                    longestPalin = s.substring(i, j+1);
                }
            }
        }

        return longestPalin;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longest = new LongestPalindromicSubstring();
        String test1 = "aaaa";
        String result1 = longest.longestPalindrome(test1);

        System.out.println(result1);
    }
}
