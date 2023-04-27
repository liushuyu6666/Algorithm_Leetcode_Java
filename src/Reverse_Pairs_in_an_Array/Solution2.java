package Reverse_Pairs_in_an_Array;

public class Solution2 {
    public int reversePairs(int[] nums) {
        int res = 0;
        int[] sorted = new int[nums.length];
        for(int span = 1; span <= nums.length; span *= 2) {
            for(int seg = 0; seg < nums.length; seg += 2 * span) {
                int start = seg, mid = Math.min(nums.length - 1, start + span), end = Math.min(nums.length, start + 2 * span), len = end - start;

                int i = start, j = mid, k = start;

                while(k < end) {
                    if(i >= mid) {
                        while(k < end) {
                            sorted[k++] = nums[j++];
                        }
                        break;
                    }
                    if(j >= end) {
                        while(k < end) {
                            sorted[k++] = nums[i++];
                        }
                        break;
                    }
                    if(nums[i] > nums[j]) {
                        res += mid - i;
                        sorted[k++] = nums[j++];
                        continue;
                    }
                    if(nums[i] <= nums[j]) {
                        sorted[k++] = nums[i++];
                        continue;
                    }
                }
            }

            int[] t = nums;
            nums = sorted;
            sorted = t;
        }

        return res;
    }
}
