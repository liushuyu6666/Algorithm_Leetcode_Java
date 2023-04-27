package Maximum_Value_of_a_Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> q;
    Deque<Integer> d;

    public MaxQueue() {
        q = new LinkedList<>();
        d = new LinkedList<>();
    }

    public int max_value() {
        return d.isEmpty() ? -1 : d.peekFirst();
    }

    public void push_back(int value) {
        q.add(value);
        int max = this.max_value();
        while(!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.addLast(value);
    }

    public int pop_front() {
        if(q.isEmpty()) {
            return -1;
        }
        int val = q.poll();
        if(val == this.max_value()) {
            d.pollFirst();
        }
        return val;
    }
}
