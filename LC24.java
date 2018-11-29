// 24. Swap Nodes in Pairs ---------- medium
// Recursion method is simple, just do the following:
// Use 1 -> 2 -> 3 -> 4 -> 5 -> null as example
// The last recursion will return node 5
// Then we swap node3 and node4 and link node4 to node5
// result in 1 -> 2 -> 3
//                4 -> 3 -> 5, and return node4
// 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LC24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = swapPairs(head.next.next);
        // This is the node needs to return after this recursion
        ListNode help = head.next;
        // Swap nodes
        head.next.next = head;
        head.next = node;
        return help;
    }
}