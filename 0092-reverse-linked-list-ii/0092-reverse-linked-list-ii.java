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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left == right  || head == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode post = dummy;
        for(int i = 1; i<=right+1; i++){
            if(i < left){
                pre = pre.next;
            }
            post = post.next;
        }
        
        ListNode next = null;
        ListNode cur = pre.next;
        ListNode end  = post;
        
        while(cur != post){
            next = cur.next;
            cur.next = end;
            end = cur;
            cur = next;
        }
        pre.next = end;
        return dummy.next;
    }
}