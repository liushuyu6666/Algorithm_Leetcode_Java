- [Overview](#overview)
- [Summary](#summary)
- [Dynamic Programming](#dynamic-programming)
- [Linked List](#linked-list)
  - [Mobius Band](#mobius-band)
- [String or StringBuilder](#string-or-stringbuilder)
  - [Insert characters into String](#insert-characters-into-string)

# Overview
This project aims to offer comprehensive Java solutions for all Leetcode questions, with carefully selected benchmark 
questions serving as exemplars for one or multiple labels, highlighting effective problem-solving approaches. While some 
questions may merit revisiting, others may be relatively straightforward to attempt.

This file serves as an index for various types of questions, utilizing benchmark questions to categorize and reference 
different methods.

# Summary
The questions and labels are listed in the `_Summary_` folder.

# Dynamic Programming
Different methods are employed for various sub-labels within dynamic programming, but the key to effective 
problem-solving lies in proper task decomposition.  

At times, Dynamic Programming questions can be transformed into `dfs` (depth-first search) questions as well. The main 
distinction is that `dfs` requires invoking itself recursively.

# Linked List
Remember there are some common strategies for handling the linked list:
1. Assuming there is a null node at the end of the list.
2. Introducing a fake head at the beginning of the list during refactoring.

We summarize from these questions:
1. [21. Merge Two Sorted Lists](src%2FMerge_Two_Sorted_Lists%2FReadme.md)

Besides, for some specific questions, we have fantastic ways to solve them.
## Mobius Band
Using Mobius Band to connect the end of the list to the start point. The question is here: [160. Intersection of Two Linked Lists
](src%2FIntersection_of_Two_Linked_Lists%2FReadme.md)

# String or StringBuilder
## Insert characters into String
When inserting characters or a string into another string, the resulting length will be altered. Therefore, it is recommended to insert characters from the end of the string.

Examples: [616. Add Bold Tag in String](src%2FAdd_Bold_Tag_in_String%2FReadme.md)


# Data Structure
## Array
### Fill in Initial Values
```java
public class HowToUseArray { 
    public void fill() {
        int[] x = new int[80];
        Arrays.fill(x, 0);
    }
}
```

## String Builder
