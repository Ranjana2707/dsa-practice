/*
Problem: Roman to Integer
Platform: LeetCode
Link: https://leetcode.com/problems/roman-to-integer/

Difficulty: Easy
Topics: String, HashMap

--------------------------------------------------

Approach (Right-to-Left Traversal):
- Store Roman numeral values in a HashMap.
- Traverse the string from right to left.
- Keep track of previous value.
- If current value < previous → subtract.
- Else → add.

--------------------------------------------------

Why this works:
- Roman numerals follow subtraction rules:
    → IV = 5 - 1
    → IX = 10 - 1
- Traversing from right makes it easy to compare with previous value.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            int curr = map.get(s.charAt(i));

            if (curr < prev) {
                total -= curr;
            } else {
                total += curr;
            }

            prev = curr;
        }

        return total;
    }

    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();

        String input = "MCMXCIV";
        int result = obj.romanToInt(input);

        System.out.println(result); // Expected: 1994
    }
}
