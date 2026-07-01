/*
Problem: Combination Sum
Platform: LeetCode
Link: https://leetcode.com/problems/combination-sum/

Difficulty: Medium
Topics: Array, Backtracking

--------------------------------------------------

Approach (Backtracking):
- Use recursion to build combinations.
- At each index:
    → Include current element (can reuse it).
    → Exclude current element and move to next index.
- If target becomes 0:
    → Store current combination.
- Stop recursion if:
    → Target becomes negative.
    → All candidates are processed.

--------------------------------------------------

Why this works:
- Backtracking explores all possible combinations.
- Reusing the same index allows unlimited use of an element.
- Prunes invalid paths when target becomes negative.

--------------------------------------------------

Time Complexity: O(2^target) (approximate, depends on input)
Space Complexity: O(target)

--------------------------------------------------
*/

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index, int[] candidates, int target,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Valid combination found
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Invalid path
        if (index == candidates.length || target < 0) {
            return;
        }

        // Include current candidate
        current.add(candidates[index]);
        backtrack(index, candidates, target - candidates[index], current, ans);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude current candidate
        backtrack(index + 1, candidates, target, current, ans);
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = obj.combinationSum(candidates, target);

        System.out.println(result);
        // Expected: [[2, 2, 3], [7]]
    }
}
