class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null)
            return null;

        if (left == right)
            return head;

        ListNode t = head;
        ListNode before = null;
        int pos = 1;

        // Reach the left position
        while (t != null) {

            if (pos < left) {
                before = t;
                t = t.next;
                pos++;
                continue;
            }

            break;
        }

        // Reverse from left to right
        ListNode curr = t;
        ListNode prev = null;

        int times = right - left + 1;

        while (times-- > 0) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect the tail of reversed part
        t.next = curr;

        // Connect the first half
        if (before != null) {
            before.next = prev;
            return head;
        }

        // If left == 1
        return prev;
    }
}