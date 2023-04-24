# Note of Validate Stack Sequences
## Stack
**Tips**: 
1. The solution 1 involves dividing the process into two steps: the "pop" process and the "push" process.  
However, complicating matters is the fact that both processes have exception conditions that require executing opposite 
logic. For instance, if the stack is empty during the "pop" process, the "push" process logic must be executed. Similarly, 
if `i` goes beyond the boundary during the "push" process, the "pop" process logic must be executed.  
   Solution 2 overcomes this problem by always pushing in the element and utilizing only one `while` statement to determine 
when to pop.
2. The stack can be implemented as an `int[]` with a `topPointer` to keep track of the top element.  
   ***Initialization***:  
    ```java
    int[] stack = new int[length];
    int topPointer = 0;
    ```
   ***push***:
    ```java
    stack[topPointer++] = num;
    ```
   ***pop***:
    ```java
    int num = stack[--topPointer];
    ```