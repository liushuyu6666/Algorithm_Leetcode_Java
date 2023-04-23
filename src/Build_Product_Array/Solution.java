package Build_Product_Array;

public class Solution {
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        if(a.length == 0) return b;
        b[0] = 1;
        int tmp = 1;

        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }

        for(int i = a.length - 2; i >= 0; i--) {
            tmp = tmp * a[i + 1];
            b[i] = b[i] * tmp;
        }

        return b;
    }
}
