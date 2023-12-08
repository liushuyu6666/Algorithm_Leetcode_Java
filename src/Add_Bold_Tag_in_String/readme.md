# types
## string
### find index of substring
### string rearrangement

# languages
## java
### string rearrangement
To address this question, the `StringBuilder` class can be a more efficient choice.

## java
### array automation initialization
#### boolean array automation initialization
In Java, boolean arrays are automatically initialized to `false` by default.

# caveats
## narrowing conditions for nested loop
When using a nested loop (whether `while` or `for`), it's important to narrow or re-check the outer condition within the nested loop. This ensures controlled and expected behavior. Here's an example:
```java
public class SolutionStringBuilder {
    public String addBoldTag(String s, String[] words) {
        boolean[] overlap = new boolean[20];
        while (i < overlap.length) {
            if(overlap[i]) {
                sb.append("<b>");
                while(i < overlap.length && overlap[i]) {
                    // Ensure that the nested loop's termination condition (i < overlap.length) is rechecked.
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append("</b>");
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
    }
}
```