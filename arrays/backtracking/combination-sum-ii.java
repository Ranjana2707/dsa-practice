/*
Problem: Combination Sum II
Platform: LeetCode
Link: https://leetcode.com/problems/combination-sum-ii/

Difficulty: Medium
Topics: Array, Backtracking

--------------------------------------------------

Approach (Backtracking + Sorting):
- Sort the array to group duplicate elements.
- Use backtracking to generate combinations.
- Each element can be used only once:
    → Move to the next index after choosing an element.
- Skip duplicate elements at the same recursion level.
- Stop exploring when current element exceeds target.

--------------------------------------------------

Why this works:
- Sorting makes duplicate detection easy.
- Skipping duplicates avoids repeated combinations.
- Backtracking explores all valid unique combinations.

--------------------------------------------------

Time Complexity: O(2^n) (worst case)
Space Complexity: O(n)

--------------------------------------------------
*/

import java.util.*;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, target, candidates, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int start, int target,
                           int[] candidates,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Valid combination found
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate elements
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // No need to continue if candidate exceeds target
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);

            // Move to next index (each element can be used only once)
            backtrack(i + 1, target - candidates[i], candidates, current, ans);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII obj = new CombinationSumII();

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = obj.combinationSum2(candidates, target);

        System.out.println(result);
        // Expected: [[1,1,6], [1,2,5], [1,7], [2,6]]
    }
}
