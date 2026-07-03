/*
Problem: Add Binary
Platform: LeetCode
Link: https://leetcode.com/problems/add-binary/

Difficulty: Easy
Topics: String, Math

--------------------------------------------------

Approach (Binary Addition):
- Traverse both strings from right to left.
- Add corresponding bits along with carry.
- Append (sum % 2) to the result.
- Update carry as (sum / 2).
- Reverse the final string to get the correct binary sum.

--------------------------------------------------

Why this works:
- Simulates manual binary addition.
- Handles strings of different lengths.
- Processes carry correctly at every step.

--------------------------------------------------

Time Complexity: O(max(m, n))
Space Complexity: O(max(m, n))

--------------------------------------------------
*/

public class AddBinary {

    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;

            if (i >= 0)
                sum += a.charAt(i--) - '0';

            if (j >= 0)
                sum += b.charAt(j--) - '0';

            ans.append(sum % 2);

            carry = sum / 2;
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary obj = new AddBinary();

        String a = "1010";
        String b = "1011";

        String result = obj.addBinary(a, b);

        System.out.println(result); // Expected: 10101
    }
}
