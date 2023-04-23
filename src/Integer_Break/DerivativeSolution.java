package Integer_Break;

public class DerivativeSolution {
    public int cuttingRope(int n) {
        if(n < 3) return 1;
        if(n == 3) return 2;
        int quotient = n / 3;
        int remainder = n % 3;
        if(remainder == 0) return (int) Math.pow(3, quotient);
        if(remainder == 1) return (int) Math.pow(3, quotient - 1) * 4;
        else return (int) Math.pow(3, quotient) * 2;
    }
}
