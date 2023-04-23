package Continuous_Positive_Integer_Sequence_with_Sum_s_II;

import java.util.ArrayList;

public class MathSolution1 {
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        ArrayList<int[]> ans = new ArrayList<>();
        while(2 * i + 1 <= target) {
            int end = this.getEnd(i, target);
            if(end != -1) {
                ans.add(this.putAns(i, end));
            }
            i++;
        }
        return ans.toArray(new int[0][]);
    }
    public long getDelta(int s, int n) {
        return 1 + 8L * n + 4 * (long) s * s - 4L * s;
    }
    public int getEnd(int s, int n) {
        long delta = getDelta(s, n);
        double sqrt = Math.sqrt(delta);
        if(sqrt != (int) sqrt) return -1;
        double end = (sqrt - 1) / 2;
        if(end != (int) end) return -1;
        if(end <= s) return -1;
        return (int) end;
    }
    public int[] putAns(int s, int end) {
        int[] res = new int[end - s + 1];
        for(int i = s; i < end + 1; i++) {
            res[i - s] = i;
        }
        return res;
    }
}
