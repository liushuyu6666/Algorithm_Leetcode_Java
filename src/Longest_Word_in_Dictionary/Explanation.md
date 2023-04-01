# Note of Longest Word in Dictionary

## Trie
**Java Tips**:
1. To sort a `string[]` by the length of word.
```java
Arrays.sort(words, Comparator.comparingInt(String::length));
```
2. To sort a `String[]` by the length and lexicographical order.
```java
Arrays.sort(words, (a, b) ->  {
    if (a.length() != b.length()) {
        return a.length() - b.length();
    } else {
        return b.compareTo(a);
    }
});
```
3. Use `String.compareTo()` to get the lexicographical order.
```java
String str1 = "apple";
String str2 = "banada";
str1.compareTo(str2) // negative
str2.compareTo(str1) // positive
```