# Note of The Occurrences of a Number in an Array
## Bits Manipulation
In mathematics, we have $$a \oplus b \oplus c \oplus a \oplus b \oplus c = 0$$. So, we have $$a \oplus b \oplus c \oplus a \oplus b \oplus c \oplus x_1 \oplus x_2 = x_1 \oplus x_2$$

In the code, we have the variable `sum`, $sum = x_1 \oplus x_2$.

The next step is to differentiate between $x_1$ and $x_2$ as they are distinct values and must have at least one differing bit.
To achieve this, we utilize the variable `filter` to identify the least significant bit 1 in the `sum`. If the binary 
representation $x_1$ at this position is 1, then it must be 0 for $x_2$ at the same position, and vice versa. Subsequently, 
we iterate through the array again using the `filter` variable to separate the entire array and obtain the final result.
