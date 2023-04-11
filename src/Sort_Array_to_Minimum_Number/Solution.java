package Sort_Array_to_Minimum_Number;

public class Solution {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            str[i] = Integer.toString(nums[i]);
        }
        quickSort(str, 0, str.length - 1);
        StringBuilder ans = new StringBuilder();
        for(String s : str) {
            ans.append(s);
        }
        return ans.toString();
    }

    public void quickSort(String[] nums, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String pivot = nums[r];
        while(i < j) {
            while(i < j && (nums[i] + pivot).compareTo((pivot + nums[i])) <= 0) i++;
            while(i < j && (pivot + nums[j]).compareTo((nums[j] + pivot)) <= 0) j--;
            String tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[r] = nums[j];
        nums[j] = pivot;
        quickSort(nums, l, j - 1);
        quickSort(nums, j + 1, r);
    }
}
