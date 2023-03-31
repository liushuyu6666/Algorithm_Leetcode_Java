package Add_Bold_Tag_in_String;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean[] indicators = new boolean[s.length()];
        Arrays.fill(indicators, false);
        HashSet<String> wordsSet = new HashSet<>(Arrays.asList(words));

        for(int i = 0; i < s.length(); i++) {
            putTrue(indicators, s, wordsSet, i);
        }

        return addTag(indicators, s);
    }

    // use s.indexOf to optimize it.
    public String advancedAddBoldTag(String s, String[] words) {
        boolean[] indicators = new boolean[s.length()];
        Arrays.fill(indicators, false);
        HashSet<String> wordsSet = new HashSet<>(Arrays.asList(words));

        for(String word : words) {
            advancedPutTrue(indicators, s, word);
        }

        String result = addTag(indicators, s);

        return result;
    }

    public void putTrue(boolean[] indicators, String s, HashSet<String> words, int startIdx) {
        for (String w : words) {
            int len = w.length();
            int endIdx = len + startIdx;
            if (endIdx <= s.length()) {
                String sub = s.substring(startIdx, endIdx);
                if (words.contains(sub)) {
                    fillTrue(indicators, startIdx, endIdx);
                }
            }
        }
    }

    public void advancedPutTrue(boolean[] indicators, String s, String word) {
        int find = s.indexOf(word, 0);
        while(find != -1) {
            fillTrue(indicators, find, find + word.length());
            find = s.indexOf(word, find + 1);
        }
    }

    public void fillTrue(boolean[] indicators, int startIdx, int endIdx) {
        for(int i = startIdx; i < endIdx; i++) {
            indicators[i] = true;
        }
    }

    public String addTag(boolean[] indicators, String s) {
        boolean latterIndicator = false;
        String newString = s;
        for (int i = indicators.length - 1; i >= 0 ; i--) {
            if (latterIndicator != indicators[i]) {
                if (latterIndicator) {
                    // curr    latter
                    // False   True
                    newString = insertTag(newString, i + 1, "<b>");
                } else {
                    // curr   latter
                    // True   False
                    newString = insertTag(newString, i + 1, "</b>");
                }
            }
            latterIndicator = indicators[i];
        }
        if (latterIndicator) {
            newString = insertTag(newString, 0, "<b>");
        }
        return newString;
    }

    public String insertTag(String s, int pos, String tag) {
        if (pos == s.length()) return s + tag;
        if (pos > s.length()) return s;
        return s.substring(0, pos) + tag + s.substring(pos);
    }
}
