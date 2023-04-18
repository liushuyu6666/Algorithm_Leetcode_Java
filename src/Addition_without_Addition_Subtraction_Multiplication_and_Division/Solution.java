package Addition_without_Addition_Subtraction_Multiplication_and_Division;

public class Solution {
    public int add(int a, int b) {
        int c;
        while(b != 0) {
            c = a;
            a ^= b;
            b = (c & b) << 1;
        }
        return a;
    }
}
