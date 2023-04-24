package Validate_Stack_Sequences;

public class Solution2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int topOfStack = 0, poppedCurr = 0;
        for(int num : pushed) {
            stack[topOfStack++] = num;
            while(topOfStack > 0 && stack[topOfStack - 1] == popped[poppedCurr]) {
                topOfStack--;
                poppedCurr++;
            }
        }
        return topOfStack == 0;
    }
}
