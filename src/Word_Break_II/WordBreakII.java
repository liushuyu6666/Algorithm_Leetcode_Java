package Word_Break_II;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Stack<Integer> branch = new Stack<>();
        List<List<Integer>> box = new ArrayList<List<Integer>>();
        dfs(s, wordDict, 0, branch, box);

        StringBuilder temp = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (List<Integer> b : box) {
            for (int i = 1; i < b.size(); i++) {
                temp.append(s, b.get(i - 1), b.get(i)).append(" ");
            }
            result.add(temp.substring(0, temp.length() - 1));
            temp = new StringBuilder();
        }

        return result;
    }

    public void dfs(String s, List<String> wordDict, int curr, Stack<Integer> branch, List<List<Integer>> box) {
        branch.add(curr);

        if (curr == s.length()) {
            box.add(new ArrayList<>(branch));
            branch.pop();
            return;
        }

        for (int i = curr + 1; i < s.length() + 1; i++) {
            String prefix = s.substring(curr, i);
            if (wordDict.contains(prefix)) {
                dfs(s, wordDict, i, branch, box);
            }
        }
        branch.pop();
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] str = new String[]{"cats","dog","sand","and","cat"};

        WordBreakII wb2 = new WordBreakII();
        wb2.wordBreak(s, List.of(str));
    }
}
