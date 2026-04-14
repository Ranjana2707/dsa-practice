/*
Problem: Merge k Sorted Lists
Platform: LeetCode
Link: https://leetcode.com/problems/merge-k-sorted-lists/

Difficulty: Hard
Topics: Linked List, Heap (Priority Queue)

--------------------------------------------------

Approach (Min Heap / Priority Queue):
- Add the head of each linked list into a min heap.
- Extract the smallest node from heap.
- Add it to the result list.
- If extracted node has next → push it into heap.
- Repeat until heap is empty.

--------------------------------------------------

Why this works:
- Heap always gives the smallest element.
- Efficient merging of k sorted lists.

--------------------------------------------------

Time Complexity: O(N log k)
(N = total nodes, k = number of lists)

Space Complexity: O(k)

--------------------------------------------------
*/

import java.util.PriorityQueue;

public class MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add all heads
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {

            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists obj = new MergeKSortedLists();

        // Example: [[1,4,5],[1,3,4],[2,6]]
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};

        ListNode result = obj.mergeKLists(lists);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Expected: 1 1 2 3 4 4 5 6
    }
}
