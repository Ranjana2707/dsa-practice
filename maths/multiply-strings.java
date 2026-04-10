/*
Problem: Multiply Strings
Platform: LeetCode
Link: https://leetcode.com/problems/multiply-strings/

Difficulty: Medium
Topics: String, Math

--------------------------------------------------

Approach (Simulation - Grade School Multiplication):
- Use an array of size m + n to store results.
- Multiply each digit of num1 with each digit of num2.
- Store result at correct positions:
    → pos1 = i + j
    → pos2 = i + j + 1
- Handle carry properly.
- Build final string while skipping leading zeros.

--------------------------------------------------

Why this works:
- Mimics manual multiplication.
- Position mapping ensures correct placement of digits.
- Avoids using BigInteger or built-in conversions.

--------------------------------------------------

Time Complexity: O(m * n)
Space Complexity: O(m + n)

--------------------------------------------------
*/

public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + result[pos2];

                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings obj = new MultiplyStrings();

        String num1 = "123";
        String num2 = "456";

        String result = obj.multiply(num1, num2);

        System.out.println(result); // Expected: 56088
    }
}
