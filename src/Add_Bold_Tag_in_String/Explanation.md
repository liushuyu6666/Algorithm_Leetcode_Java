# Note of Add Bold Tag in String
## check the substring
This is the normal solution.
```java
for (String word : words) {
    int len = word.length();
    if (words.contains(s.substring(startIndex, startIndex + len))) {
        // ...    
    }
}
```
## Optimize
Use `s.indexOf` to optimize the whole process.

## KMP