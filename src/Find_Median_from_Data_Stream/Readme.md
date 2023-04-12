# Note of Find Median from Data Stream
## Priority Queue
**Java**: Using a Java Priority Queue, this question implements a data structure that follows a 'FIFO' (First-In, First-Out) 
approach for normal queues, but prioritizes elements based on their priority for removal in the Priority Queue.  
In this question we define the priority using a comparator.
```java
/*
  If return a negative value, the first element has higher priority.
  Larger elements have higher priority in `this.lessQueue`, resulting in them being polled out first.
*/
this.lessQueue = new PriorityQueue<>((a, b) -> b - a)
```