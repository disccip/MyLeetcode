// 92. Reverse Linked List II ---------medium
// My idea is the almost the same as Reverse Linked List I
// the different is to return the head of the reversed part and 
// the next element of the tail

class LC92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        int num = n - m;
        ListNode dummy = new ListNode(-1), cur = dummy;
        dummy.next = head;
        while (m - 1 > 0)
        {
            cur = cur.next;
            m--;
        }
        ListNode memo1 = cur.next, memo2 = cur;
        ListNode[] res = reverse(cur.next, num);
        memo2.next = res[0];
        memo1.next = res[1];
        return dummy.next;
        
    }
    
    private ListNode[] reverse(ListNode head, int num)
    {
        if (num == 0 || head.next == null) return new ListNode[]{head, head.next};
        ListNode[] ret = reverse(head.next, num - 1);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}

// Another neat method

class LC92
{
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1), prev = dummy;
        // Get the node just before the start reverse position
        for (i = 0; i < m - 1; i++) 
            prev = prev.next;
        // Get the node at start positon and the node after it
        // since m and n will always be valid, so next will always valid
        ListNode cur = prev.next, next = cur.next;
        // Use dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null, m = 1, n = 4 as example
        //     prev    cur  next
        for (int i = 0; i < n - m; i++)
        {
            cur.next = next.next; // dummy -> 1 -> 3 -> 4 -> 5 -> null
                                  //          2 ->
            next.next = pre.next; // dummy -> 1 -> 3 -> 4 -> 5 -> null
                                  //     2 ->
            pre.next = next;      // dummy -> 2 -> 1 -> 3 -> 4 -> 5 -> null
            next = cur.next;      // dummy -> 2 -> 1 -> 3 -> 4 -> 5 -> null
                                  // prev         cur  next
        }
        return dummy.next;
    }
}