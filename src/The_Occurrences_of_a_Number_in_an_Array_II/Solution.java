package The_Occurrences_of_a_Number_in_an_Array_II;

public class Solution {
    public int singleNumber(int[] nums) {
        int state = 0, auxiliary = 0;
        for(int num : nums) {
            state = (num ^ state) & ~auxiliary;
            auxiliary = (num ^ auxiliary) & ~state;
        }
        return state;
    }
}
