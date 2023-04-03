package Find_Minimum_in_Rotated_Sorted_Array_II;

public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public int dfs(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return nums[leftIndex];
        }
        int midIndex = (leftIndex + rightIndex) / 2;
        if (nums[midIndex] > nums[rightIndex]) {
            return dfs(nums, midIndex + 1, rightIndex);
        }
        if (nums[midIndex] < nums[rightIndex]) {
            return dfs(nums, leftIndex, midIndex);
        }
        return Math.min(dfs(nums, leftIndex, midIndex), dfs(nums, midIndex + 1, rightIndex));
    }
}
