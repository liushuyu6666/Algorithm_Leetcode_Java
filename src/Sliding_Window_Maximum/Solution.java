package Sliding_Window_Maximum;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    Deque<Integer> d;
    public int[] maxSlidingWindow(int[] nums, int k) {
        d = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for(int i = -k, j = 0; j < nums.length; i++, j++) {
            this.insert(nums[j]);
            if(i >= 0) {
                this.remove(nums[i]);
            };
            if(i >= -1) {
                ans[i + 1] = this.getLast();
            }
        }
        return ans;
    }
    public void insert(int x) {
        while(!this.d.isEmpty() && this.d.peekFirst() < x) {
            this.d.pollFirst();
        }
        this.d.addFirst(x);
    }
    public void remove(int x) {
        if(!this.d.isEmpty() && this.d.peekLast() == x) {
            this.d.pollLast();
        }
    }
    public int getLast() {
        return this.d.peekLast();
    }
}
