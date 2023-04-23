# Note of Integer Break
## Math
To maximize the value in accordance with the Inequality of Arithmetic and Geometric Means:
$$\frac{x_1 + x_2 + ... + x_a}{a} \geq \sqrt[a]{x_1x_2...x_a}$$
it is necessary to set all segment lengths to be equal, as the maximum value is obtained only when $x_1 = x_2 = ... = x_a$.  

Let the length of each segment be $x$. Then there are $a$ segments, where:
$$a = \frac{n}{x}$$
The maximum production is given by $s = x^{\frac{n}{x}}$. Since $n$ is a constant value, we actually need to find the maximum value of 
$$y = x^{\frac{1}{x}}$$
Take the logarithm of both sides of the equation:
$$\ln(y) = \frac{1}{x}\ln(x)$$
To find the derivative of both sides of the equation with respect to $x$, since $y$ is a function of $x$, we use the 
chain rule to obtain
$$\frac{1}{y}\dot{y} = \frac{1-\ln(x)}{x^2}$$
$$\dot{y} = \frac{1-\ln(x)}{x^2} \cdot x^{\frac{1}{x}}$$
When $\ln(x) = 1$, i.e., $x = e$, a stationary point is obtained, which corresponds to the maximum value. As $e$ is not 
an integer, the closest integers are 2 and 3. Setting $n = 6$, we find that $2^{\frac{6}{2}} < 3^{\frac{6}{3}}$, indicating 
that the maximum value is achieved when $x = 3$.  

We also need to consider the remainder:
1. When the remainder is `0`, the maximum value is $3^{\frac{n}{3}}$
2. When the remainder is `1`, the last `3` should be combined with the remainder `1` to become `4`, because $3 \prod 1 < 2 \prod 2$
3. When the remainder is `2`, keep it.