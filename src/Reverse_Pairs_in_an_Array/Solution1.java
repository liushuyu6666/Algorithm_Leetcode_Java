package Reverse_Pairs_in_an_Array;

public class Solution1 {
    public int reversePairs(int[] nums) {
        if(nums.length < 1) return 0;
        return merge_sort(0, nums.length - 1, nums);
    }

    public int merge_sort(int l, int r, int[] nums) {
        if(l == r) return 0;
        int m = (l + r) / 2;
        int len = r + 1 - l;

        int res = merge_sort(l, m, nums) + merge_sort(m + 1, r, nums);

        // sort
        int[] sorted = new int[len];
        int i = l, j = m + 1, k = 0;
        while(k < len) {
            if(i > m) {
                while(k < len) {
                    sorted[k++] = nums[j++];
                }
                break;
            }
            if(j > r) {
                while(k < len) {
                    sorted[k++] = nums[i++];
                }
                break;
            }
            if(nums[i] > nums[j]) {
                res += m + 1 - i;
                sorted[k++] = nums[j++];
                continue;
            }
            if(nums[i] <= nums[j]) {
                sorted[k++] = nums[i++];
                continue;
            }
        }

        // update nums
        for(k = 0; k < len; k++) {
            nums[k + l] = sorted[k];
        }

        return res;
    }
}
