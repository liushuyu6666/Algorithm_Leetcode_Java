package Continuous_Positive_Integer_Sequence_with_Sum_s_II;

import java.util.ArrayList;

public class SlidingWindowSolution {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, sum = 0;
        ArrayList<int[]> ans = new ArrayList<>();
        while(i < j && j < target) {
            sum = this.getSum(i, j);
            if(sum < target) {
                j++;
            } else if(sum > target) {
                i++;
            } else {
                ans.add(putAns(i, j));
                i++;
            }
        }
        return ans.toArray(new int[0][]);
    }
    public int getSum(int i, int j) {
        return ((i + j) * (j - i + 1)) / 2;
    }
    public int[] putAns(int i, int j) {
        int[] ans = new int[j - i + 1];
        for(int s = i; s <= j; s++) {
            ans[s - i] = s;
        }
        return ans;
    }
}
