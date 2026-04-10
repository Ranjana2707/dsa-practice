/*
Problem: Divide Two Integers
Platform: LeetCode
Link: https://leetcode.com/problems/divide-two-integers/

Difficulty: Medium
Topics: Math, Bit Manipulation

--------------------------------------------------

Approach (Bit Manipulation / Exponential Search):
- Handle overflow case:
    → Integer.MIN_VALUE / -1

- Determine sign of result.

- Convert to long to avoid overflow.

- Repeatedly subtract divisor using doubling:
    → Keep doubling divisor (temp <<= 1)
    → Track multiples

- Subtract largest possible chunk each time.

--------------------------------------------------

Why this works:
- Doubling allows us to subtract large chunks → faster than linear subtraction.
- Similar to binary search / exponential growth.

--------------------------------------------------

Time Complexity: O(log n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        // Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        int sign = (dividend > 0) == (divisor > 0) ? 1 : -1;

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int result = 0;

        while (dvd >= dvs) {

            long temp = dvs;
            int multiple = 1;

            // Double divisor until it exceeds dividend
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            result += multiple;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers obj = new DivideTwoIntegers();

        int dividend = 10;
        int divisor = 3;

        int result = obj.divide(dividend, divisor);

        System.out.println(result); // Expected: 3
    }
}
