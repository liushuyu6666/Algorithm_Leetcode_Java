package Find_Median_from_Data_Stream;

import java.util.PriorityQueue;

class MedianFinder {
    public PriorityQueue<Integer> lessQueue;
    public PriorityQueue<Integer> largerQueue;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.lessQueue = new PriorityQueue<>((a, b) -> b - a); // large to small
        this.largerQueue = new PriorityQueue<>((a, b) -> a - b); // small to large
    }

    public void addNum(int num) {
        if(this.lessQueue.isEmpty() && this.largerQueue.isEmpty()) {
            this.lessQueue.add(num);
            return;
        }
        if(num <= this.findMedian()) {
            this.lessQueue.add(num);
        } else {
            this.largerQueue.add(num);
        }

        if(lessQueue.size() < largerQueue.size()) {
            int temp = largerQueue.poll();
            lessQueue.add(temp);
        } else if (lessQueue.size() - 1 > largerQueue.size()) {
            int temp = lessQueue.poll();
            largerQueue.add(temp);
        }

        // System.out.println(lessQueue);
        // System.out.println(largerQueue);
    }

    public double findMedian() {
        if(this.lessQueue.size() == this.largerQueue.size()) {
            return (this.lessQueue.peek() + this.largerQueue.peek()) / 2.0;
        } else {
            return this.lessQueue.peek();
        }
    }
}
