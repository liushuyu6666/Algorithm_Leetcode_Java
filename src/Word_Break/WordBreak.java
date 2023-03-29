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

    public boolean wordBreakDFS(String s, List<String> wordDict) {
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return this.canBeBrokenDFS(s, wordDict, memo, 0);
    }

    // check if s.substring(sep, s.length()) can be broken
    // memo means s.substring(i, s.length()) can be broken
    private boolean canBeBrokenDFS(String s, List<String> wordDict, HashMap<Integer, Boolean> memo, int sep) {
        if (sep >= s.length()) return true;
        if (memo.containsKey(sep)) return memo.get(sep);

        for (int i = sep + 1; i < s.length() + 1; i++) {
            String prefix = s.substring(sep, i);
            if (wordDict.contains(prefix) && this.canBeBrokenDFS(s, wordDict, memo, i)) {
                memo.put(sep, true);
                return true;
            }
        }
        memo.put(sep, false);
        return false;
    }

    public boolean wordBreakBFS(String s, List<String> wordDict) {
        Queue<Integer> qu = new LinkedList<>();
        HashSet<Integer> memo = new HashSet<>();
        qu.add(0);

        return this.canBeBrokenBFS(s, wordDict, memo, qu);
    }

    private boolean canBeBrokenBFS(String s, List<String> wordDict, HashSet<Integer> visited, Queue<Integer> qu)  {
        if (qu.isEmpty()) return false;
        if (qu.peek() == s.length()) return true;

        Integer sep = qu.poll();
        if (!visited.contains(sep)) {
            visited.add(sep);
            for (int i = sep + 1; i < s.length() + 1; i++) {
                String prefix = s.substring(sep, i);
                if (wordDict.contains(prefix)) {
                    qu.add(i);
                }
            }
        }
        return this.canBeBrokenBFS(s, wordDict, visited, qu);
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        String s = "catsandog";
        String[] str = new String[]{"cats","dog","sand","and","cat"};
        List<String> wordDict = new ArrayList<>(Arrays.asList(str));

        System.out.println(wb.wordBreakDynamicProgramming(s, wordDict));
        System.out.println(wb.wordBreakKnapsack(s, wordDict));
        System.out.println(wb.wordBreakDFS(s, wordDict));
        System.out.println(wb.wordBreakBFS(s, wordDict));

    }
}
