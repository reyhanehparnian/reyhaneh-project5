Project 5: The Two Towers
Author: Reyhaneh Parnian
Date: April 19, 2025

1.
My program returned the following best subset for the 15-block problem:
Target (optimal) height: 20.234598300071305
Best subset: 4 5 6 10 11 12 13
Best height: 20.23411306140849
Distance from optimal: 4.8523866281513506E-4
Solve duration: 27 ms

2.
I ran the solver 3 times for 20, 21, and 22 blocks. Below are the results averaged over 3 runs:
Blocks | Average Solve Time (ms) | Best Height        | Distance from Optimal
20     |  150 ms                 | 30.832953059742387 | 0.00003584596751693425
21     |  293 ms                 | 33.124255277107125 | 0.00002147608069691387
22     |  541 ms                 | 35.46945630059705  | 0.000028332502481021038

The runtime increases very rapidly with each additional block:
    1. For 20 blocks, the average solve time was 150 ms
    2. For 21 blocks, it almost doubled to 293 ms
    3. For 22 blocks, it nearly doubled again to 541 ms
This sharp increase clearly isn’t linear or even quadratic — it's exponential.

This makes perfect sense due to how the program is designed. We're generating every possible subset of the blocks
to find the best configuration, which means: For n blocks, there are 2^n possible subsets. So when:
    1. n = 20, we check over 1 million subsets.
    2. n = 21, that doubles to over 2 million.
    3. n = 22, over 4 million subsets.
Even though each individual subset is processed relatively quickly, the sheer number of subsets grows exponentially,
making the program's time complexity O(n × 2ⁿ). That’s why adding just one more block causes a big jump in runtime.

3.
The time complexity of this program is approximately O(n × 2ⁿ) due to the exhaustive enumeration of all subsets.
For n = 22, the program already takes over 500 ms to explore about 4 million subsets. If we extend this to n = 50,
the number of subsets becomes: 2^50 ≈ 1.13 × 10^15 subsets
My program handled 4 million subsets in ~541 ms, so:
Time per subset => 541 ms / 4,194,304 ≈ 0.000129 ms
Estimated time for 2^50 subsets = 0.000129 ms × (2^50) ≈ 0.000129 ms × 1.1259 × 10^15 ≈ 1.45 × 10^11 ms ≈ 4.6 years