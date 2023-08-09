# Algorithms or Skills
## Algorithms - Dynamic programming
To address this problem, a dynamic programming (`dp`) matrix is employed, where `dp[i][j]` signifies the minimal total hours expended while traversing the `(i - 1)th` road and having already skipped j times rest.

![dp_matrix.png](dp_matrix.png)

Upon traversing a given road (`dist[i]`), the number of times skipped could range from 0 to `i`. Thus, within the depicted matrix, `dp[i][j]` with `j > i` is infeasible, representing unreachable states. For instance, having crossed 7 roads, skipping 8 times is an impractical scenario.
It is established by the problem's conditions that the final rest period is not permissible at the termination of the last road. Consequently, the `dp` matrix excludes coverage of the last road.

**Initial State**: Initializing the `dp` matrix involves assigning huge values to the unreachable states and setting the first row to 0, symbolizing the hours required in the absence of any road crossings.
**Transition Equation**: The transition equation is straightforward and is best comprehended through examination of the provided code.

## Skills - Floating-Point Numbers
Deviation can arise when performing operations on arithmetic floating-point numbers. Consider the equation $1.0 / 3 + 1.0 / 3 + 1.0 / 3$, which should equal 1. However, due to computational limitations, the computer might yield a value like 1.0000000000000000000000002. Rounding this value could erroneously result in 2 instead of 1. To mitigate this issue, employing a diminutive variable `eps` is recommended. This `eps` should be sufficiently small. Refer to the code for further elucidation. We should use `eps` in the following situations:
- round function. `double val = Math.ceil(a - eps);`
- comparison statement. `if(a - eps > b);`

A critical constraint in this problem is the range of speeds, bounded by $1 \leq \text{speed} \leq 10^{6}$. This implies that the smallest valid value is $10^{-6}$, which becomes relevant when considering a scenario where the distance is 1 and the speed is $10^{6}$. Consequently, to accommodate such precision requirements, it is necessary to set the value of `eps` to a value smaller than $10^{-6}$.