/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q_019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode first = head;
        while(first != null) {
            len++;
            first = first.next;
        }
        len -= n;
        first = dummy;
        while (len > 0) {
            len--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}