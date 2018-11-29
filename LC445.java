// 445. Add Two Numbers II

// Method1. two-pass, use stack, create new ListNode, O(N) time O(N) space;
class LC445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode n1 = l1, n2 = l2;
        while (n1 != null)
        {
            s1.push(n1.val);
            n1 = n1.next;
        }
        while (n2 != null)
        {
            s2.push(n2.val);
            n2 = n2.next;
        }
        ListNode node = null;
        int carry = 0;
        while (!s1.isEmpty() && !s2.isEmpty())
        {
            int sum = s1.pop() + s2.pop() + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            temp.next = node;
            node = temp;
        }
        while (!s1.isEmpty())
        {
            int sum = s1.pop() + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            temp.next = node;
            node = temp;
        }
        while (!s2.isEmpty())
        {
            int sum = s2.pop() + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            temp.next = node;
            node = temp;
        }
        if (carry != 0)
        {
            ListNode temp = new ListNode(carry);
            temp.next = node;
            node = temp;
        }
        return node;
    }
}

// Method2, reverse list
class LC445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode head = new ListNode(-1), pre = head;
        pre.next = l1;
        while (l1 != null || l2 != null || carry != 0)
        {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            if (l1 !=  null)
            {
                l1.val = sum % 10;
            }
            else if (l2 == null)
            {
                pre.next = new ListNode(sum);
            }
            else
            {
                l2.val = sum % 10;
                pre.next = l2;
            }
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            pre = pre.next;
        }
        return reverse(head.next);
    }
    
    private ListNode reverse(ListNode root)
    {
        if (root == null || root.next == null) return root;
        ListNode prev = null;
        while (root != null)
        {
            ListNode cur = root.next;
            root.next = prev;
            prev = root;
            root = cur;
        }
        return prev;
    }
}