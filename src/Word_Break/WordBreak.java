package Word_Break;

import java.util.*;

public class WordBreak {
    public boolean wordBreakDynamicProgramming(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        // dp[x] -> s.substring(0, x); [0, x)
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                String right = s.substring(j, i);
                if (dp[j] & set.contains(right)) {
                    dp[i] = true;
                    break;
                }
                dp[i] = false;
            }
        }

        return dp[s.length()];
    }

    public boolean wordBreakKnapsack(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (String w : set) {
                int l = w.length();
                if (i >= l && dp[i - l] && w.equals(s.substring(i - l, i))) {
                    dp[i] = true;
                    break;
                }
                dp[i] = false;
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] str = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                "aaaaaaaaaa"};
        List<String> wordDict = new ArrayList<>(Arrays.asList(str));

        System.out.println(wb.wordBreakDynamicProgramming(s, wordDict));
        System.out.println(wb.wordBreakKnapsack(s, wordDict));

    }
}
