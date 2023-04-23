package Continuous_Positive_Integer_Sequence_with_Sum_s_II;

import java.util.ArrayList;
import java.util.Collections;

public class MathSolution2 {
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        ArrayList<int[]> ans = new ArrayList<>();
        while(2 * target > i * (i + 1)) {
            double s = (target - ((double)i * (i + 1) / 2)) / (double)(i + 1);
            if(s == (int) s) {
                ans.add(putAns((int)s, i));
            }
            i++;
        }
        Collections.reverse(ans);
        return ans.toArray(new int[0][]);
    }
    public int[] putAns(int s, int i) {
        int end = s + i;
        int[] ans = new int[i + 1];
        for(int j = s; j <= end; j++) {
            ans[j - s] = j;
        }
        return ans;
    }
}
