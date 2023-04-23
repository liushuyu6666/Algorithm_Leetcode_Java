# Note of Majority Element
## Boyer–Moore majority vote algorithm
**Note**: Kindly be advised that the term 'majority element' in this context refers specifically to the element that 
occurs more than half of the total elements in the array.  

The Bayer-Moore majority vote algorithm assigns a value of 1 to the majority element and -1 to all others. By summing up
the values of all elements using the `vote` variable, the majority element can be identified when the total value is greater 
than 0.  

* Inference 1：Specifically, if a range is selected in which the majority element occupies exactly half of the positions 
(or less than half), then it will still remain the majority element in the rest of the array.
* Inference 2：If a range is selected in which the majority element occupies less than half of the positions, then it will 
still remain the majority element in the rest of the array.

However, since the majority element is not known in advance, the algorithm assumes the first element of a range to be the 
majority element. This assumed element is assigned a value of 1, while all others are assigned a value of -1. , The range 
ends when the `vote` variable becomes 0, at which point the assumed element is known to occupy half of the positions in 
the range.  

Although the assumed majority element may differ from the actual majority element, the latter will always occupy more than 
half of the positions in the remaining array. This is due to the following reasons:
1. If the assumed majority element is in fact the actual majority element, it will still be the majority element according 
to inference 1.
2. If the assumed majority element is not the actual majority element, the actual majority element will still take up more 
than half of the positions in the remaining array, as per inference 2.  

Hence, the algorithm removes the previous range and starts another loop. The final assumed majority element will then be
confirmed as the actual majority element.