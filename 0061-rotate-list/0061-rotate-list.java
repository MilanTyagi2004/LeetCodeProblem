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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return null;
        int len = 1;
        ListNode temp =head;
        while(temp.next!=null){
            len++;
            temp = temp.next; 
        }
        k  = k% len;
        if(k==0){
            return head;
        }
        int remain = len-k;
        ListNode remaining = head;
        for(int i=1;i<remain;i++){
            remaining = remaining.next;
        }
        temp.next = head;
        head = remaining.next;
        remaining.next = null;
        return head;
    }
}