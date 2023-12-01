# Algorithms and Skills
## Solution1 - Two Pointers (Sliding Window)








## Skills - Two loops in parallel
In this problem, we actually have two loops
- When `sum < target`, we need to expand the right boundary of our window until `sum >= target`.
- When `sum >= target`, we need to shrink the left boundary of our window until `sum < target`.
However, how to handle with these two loops haunt us. For both loop, we need to check both `i` and `j`'s bound. Besides, these two loop are closely linked. When quit the first loop, we need to go into the second loop, and when finish the second loop, we need to go into the first loop. So, we need a outer bigger loop to wrap them if we want to use these loops in parallel.
One possible solution is to use one loop to wrap another. Let's optimize the process:
- When `j < nums.length`, we move j right forward
  - In this loop, we will check if `sum >= target`, if so, we update the `ans` and move `i` right forwards until `sum < target`.

## Skills - Initialization
Since we would like to use 
```java
while(j < nums.length && sum < target) {
    // actual code
    j++;
}
```
`j++;` statement must be put at the end, which means `sum` must be calculated before `j++`. In another word, we move the `j` in the previous loop and update the `sum` at the beginning of the next loop. So, the `j` should point to the potential element which will be loading into the `sum`. Then we will have the code snippet:
```java
while(j < nums.length && sum < target) {
    sum += nums[j];
    j++;
}
```
