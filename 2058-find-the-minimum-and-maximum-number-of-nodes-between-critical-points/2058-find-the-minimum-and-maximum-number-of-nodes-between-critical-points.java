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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return new int[] {-1,-1};
        List<Integer> diff = new ArrayList<>();


        ListNode curr = head.next;
        ListNode prev = head;
        ListNode nxt = curr.next;
        int idx = 2;
        int first = Integer.MAX_VALUE;
        int last = 0;

        int min = Integer.MAX_VALUE;

        while(nxt != null) {
            if(curr.val > prev.val && curr.val > nxt.val) {
                if(first == Integer.MAX_VALUE) {
                    first = idx;
                }
                else{
                    min = Math.min(min, idx - last);
                }
                last = idx;
                diff.add(idx);
            }
            else if(curr.val < prev.val && curr.val < nxt.val) {
                if(first == Integer.MAX_VALUE) {
                    first = idx;
                }
                else{
                    min = Math.min(min, idx - last);
                }
                last = idx;
                diff.add(idx);
            }
            prev = curr;
            curr = nxt;
            nxt = nxt.next;
            idx++;
        }

        if(diff.size() < 2) return new int[] {-1,-1};
        
        return new int[] {min, last - first};
    }
}