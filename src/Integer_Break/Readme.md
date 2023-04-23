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
$$\frac{1}{y}y' = \frac{1-\lnx}{x^2}$$