# Note of Continuous Positive Integer Sequence with Sum s II
## Math
Consider a Continuous Positive Integer Sequence starting at `s` and ending at `x`, with a target sum of `n`. Then,
$$(s + x)(x - s + 1) = 2n$$
$$x^2 + x - s^2 + s - 2n = 0$$
So, we have
$$\delta = 8n + 4 s^2 - 4s + 1$$
The positive root
$$x = \frac{\sqrt{\delta} - 1}{2}$$
It is important to ensure that `x` is an integer and less than `s`.