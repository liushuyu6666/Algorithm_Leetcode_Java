package The_Occurrences_of_a_Number_in_an_Array;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        int filter = 1;
        while((sum & filter) == 0) {
            filter = filter << 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & filter) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
