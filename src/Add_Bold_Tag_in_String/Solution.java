package Add_Bold_Tag_in_String;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean[] overlap = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            overlap[i] = false;
        }

        for (String word : words) {
            findWordInString(s, word, overlap);
        }

        return addBoldTags(s, overlap);
    }

    public String addBoldTags(String s, boolean[] overlap) {
        boolean prev = false;
        for(int i = overlap.length - 1; i >= 0; i--) {
            if(overlap[i] && !prev) { // curr is true but prev is false
                s = s.substring(0, i + 1) + "</b>" + s.substring(i + 1);
            } else if(!overlap[i] && prev) {
                s = s.substring(0, i + 1) + "<b>" + s.substring(i + 1);
            }
            prev = overlap[i];
        }
        if (overlap[0]) {
            s = "<b>" + s;
        }

        return s;
    }



    public void findWordInString(String s, String word, boolean[] overlap) {
        int length = word.length();
        int findIndex = s.indexOf(word, 0);

        while(findIndex != -1) {
            updateListSlice(overlap, findIndex, findIndex + length, true);
            findIndex = s.indexOf(word, findIndex + 1);
        }

    }

    public void updateListSlice(boolean[] overlap, int startIdx, int endIdx, boolean newValue) {
        for(int i = startIdx; i < endIdx; i++) {
            overlap[i] = newValue;
        }
    }
}
