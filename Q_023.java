/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Using Priority Queue with runnning time is O(nlogk)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;
        PriorityQueue<ListNode> Queue = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(ListNode list : lists) {
            if(list != null) {
                Queue.add(list);
            }
        }
        while(!Queue.isEmpty()) {
            curr.next = Queue.poll();
            curr = curr.next;
            if(curr.next != null) {
                Queue.add(curr.next);
            }
        }
        return dummy.next;
    }
}