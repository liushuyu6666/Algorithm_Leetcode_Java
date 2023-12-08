package Add_Bold_Tag_in_String;

import java.util.Arrays;
import java.util.Collections;

public class SolutionStringBuilder {
    public String addBoldTag(String s, String[] words) {
        // In Java, boolean arrays are automatically initialized to false by default, or use Arrays.fill(overlap, false).
        boolean[] overlap = new boolean[s.length()];

        for (String word : words) {
            int findIndex = s.indexOf(word);
            while(findIndex != -1) {
                for (int i = findIndex; i < findIndex + word.length(); i++) {
                    overlap[i] = true;
                }
                findIndex = s.indexOf(word, findIndex + 1);
            }
        }

        // debug: overlap

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < overlap.length) {
            if(overlap[i]) {
                sb.append("<b>");
                while(i < overlap.length && overlap[i]) {
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append("</b>");
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}
