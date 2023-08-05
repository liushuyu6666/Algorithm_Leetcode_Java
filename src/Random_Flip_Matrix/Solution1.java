package Random_Flip_Matrix;

import java.util.HashMap;
import java.util.Random;

public class Solution1 {
    HashMap<Integer, Integer> map;

    int lastValidIndex;

    int m;

    int n;

    Random rand;

    public Solution1(int m, int n) {
        this.map = new HashMap<>();
        this.lastValidIndex = m * n - 1;
        this.m = m;
        this.n = n;
        this.rand = new Random();
    }

    public int[] flip() {
        int x = this.rand.nextInt(this.lastValidIndex + 1); // x is the generated random integer.

        int validMatrixIndex = this.map.getOrDefault(x, x); // get valid matrix index.

        this.map.put(x, this.map.getOrDefault(this.lastValidIndex, this.lastValidIndex));

        this.lastValidIndex--;

        return new int[]{validMatrixIndex / this.n, validMatrixIndex % this.n};
    }

    public void reset() {
        this.map = new HashMap<>();
        this.lastValidIndex = m * n - 1;
        this.rand = new Random();
    }
}
