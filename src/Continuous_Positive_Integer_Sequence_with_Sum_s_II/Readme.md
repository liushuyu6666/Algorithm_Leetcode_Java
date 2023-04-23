# Note of Continuous Positive Integer Sequence with Sum s II
## Math 1
Consider a Continuous Positive Integer Sequence starting at `s` and ending at `x`, with a target sum of `n`. Then,
$$(s + x)(x - s + 1) = 2n$$
$$x^2 + x - s^2 + s - 2n = 0$$
So, we have
$$\Delta = 8n + 4 s^2 - 4s + 1$$
The positive root
$$x = \frac{\sqrt{\Delta} - 1}{2}$$
It is important to ensure that `x` is an integer and less than `s`.

**Tip**: Convert `List` to `int[][]` we can use `Collections.toArray(new int[0][])`  
In Java, `new int[0][]` creates a new empty two-dimensional integer array.  
In the context of `Collections.toArray(new int[0][])`, the `toArray` method is used to convert an `ArrayList` of integer 
arrays to a two-dimensional integer array. The argument `new int[0][]` is a type-safe way of passing an empty two-dimensional 
integer array to the `toArray` method, so that it can be filled with the elements of the `ArrayList`.



## Math 2
The second method shifts the focus from the starting element to the interval of the range. By defining the interval as $i = x - s$ 
and using the equation $(s + x)(x - s + 1) = 2n$, we can simplify it to $(2s + i)(i + 1) = 2n$. Finally, we get
$$s = \frac{n - \frac{i(i+1)}{2}}{i + 1}$$
Note that $s$ must be a positive integer, we have:
1. $$t > \frac{i(i+1)}{2}$$.
2. $$\frac{n - \frac{i(i+1)}{2}}{i + 1}$$ is an integer.

## Sliding Window
The code is essy to understand.