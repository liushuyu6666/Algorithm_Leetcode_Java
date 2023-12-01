package Minimum_Size_Subarray_Sum;

public class Solution1 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, ans = Integer.MAX_VALUE, i = 0, j = 0, sum = 0;

        while(j < n) {
            sum += nums[j];
            j++;
            while(sum >= target) {
                ans = Math.min(ans, j - i);
                sum = sum - nums[i];
                i++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
