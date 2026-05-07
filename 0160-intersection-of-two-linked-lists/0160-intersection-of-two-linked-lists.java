/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t = headA;
        ListNode t1 = headB;

        while(t!=t1){
            t= (t==null)?headB:t.next;
            t1= (t1==null)?headA:t1.next;
        }
        return t1;
    }
}