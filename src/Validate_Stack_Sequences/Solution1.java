package Validate_Stack_Sequences;

import java.util.Stack;

public class Solution1 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while(j < popped.length) {
            // push process
            if(stack.isEmpty() || stack.peek() != popped[j]) {
                if(i >= pushed.length) return false;
                stack.push(pushed[i]);
                i++;
            }

            // pop process
            if(i >= pushed.length || stack.peek() == popped[j]) {
                if(stack.isEmpty()) return false;
                int pop = stack.pop();
                if(pop != popped[j]) return false;
                j++;
            }
        }
        return true;
    }
}
