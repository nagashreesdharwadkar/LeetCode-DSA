class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0); // Dummy head
        ListNode current = dummy;         // Result pointer
        int carry = 0;                    // Store carry

        // Process while nodes exist or carry remains
        while (l1 != null || l2 != null || carry != 0) {

            int val1 = (l1 != null) ? l1.val : 0; // Value from l1
            int val2 = (l2 != null) ? l2.val : 0; // Value from l2

            int sum = val1 + val2 + carry; // Add digits + carry
            carry = sum / 10;              // Update carry

            current.next = new ListNode(sum % 10); // Store digit
            current = current.next;                // Move pointer

            if (l1 != null) l1 = l1.next; // Move l1
            if (l2 != null) l2 = l2.next; // Move l2
        }

        return dummy.next; // Skip dummy node
    }
}