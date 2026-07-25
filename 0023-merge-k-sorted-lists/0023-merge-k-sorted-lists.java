/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while(temp != null) {
                minHeap.offer(temp.val);
                temp = temp.next;
            }
        }

        if(minHeap.size() == 0) return null;
        ListNode ans = new ListNode(minHeap.poll());
        ListNode temp = ans;
        
        while(!minHeap.isEmpty()) {
            
            ListNode newNode = new ListNode(minHeap.poll());

            temp.next = newNode;
            temp = temp.next;
        }
        return ans;
    }
}