package Ugly_Number_II;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n + 1];
        ugly[1] = 1;
        int a = 1, b = 1, c = 1, prev = 1, curr = 2;

        while(curr <= n) {
            while(2 * ugly[a] <= ugly[prev]) {
                a++;
            }
            while(3 * ugly[b] <= ugly[prev]) {
                b++;
            }
            while(5 * ugly[c] <= ugly[prev]) {
                c++;
            }
            ugly[curr] = Math.min(ugly[a] * 2, Math.min(ugly[b] * 3, ugly[c] * 5));
            prev = curr;
            curr++;
        }

        return ugly[n];
    }
}
