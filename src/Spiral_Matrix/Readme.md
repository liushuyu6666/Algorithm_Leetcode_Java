# Note of Spiral Matrix
## Solution
1. Establish boundaries in all four directions - left, right, up, and down.
2. "squashing" the boundaries.

## Caveat
1. redundant conditional checking: The condition is redundantly checked within each part of the loop's body. This approach is adopted due to the following reasons:
   1. **Sequential Execution**: Each part is executed within the loop in sequence.
   2. **Dynamic Variable Updates**: Since conditional variables will be updated within each part, it is necessary to reevaluate the condition before proceeding to the next part.
![Squash_the_boundaries.png](Squash_the_boundaries.png)