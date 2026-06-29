class Solution {
    public void reorderList(ListNode head){
        if(head == null || head.next == null)
        return;
        // Step 1:Find middle
        ListNode slow = head, fast = head;
        while(fast !=null &&  fast.next!=null ){
          slow = slow.next;
          fast = fast.next.next;

        }
        //Reverse Second half
        ListNode prev = null;
        while(slow != null){
                ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        //Merge two halves
        ListNode first = head;
        ListNode second = prev;

        while(second.next != null){
            ListNode temp1= first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;
            first = temp1;
             second = temp2;


        }

    }
}