package Majority_Element;

public class Solution {
    public int majorityElement(int[] nums) {
        int x = nums[0], vote = 0;
        for(int num : nums) {
            if(vote == 0) {
                x = num;
            }
            if(num == x) {
                vote++;
            } else {
                vote--;
            }
        }
        return x;
    }
}
