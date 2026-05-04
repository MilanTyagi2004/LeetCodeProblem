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
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1 = reverse(l1);
        // l2 = reverse(l2);
        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;

        while(l1!=null && l2!=null){
            int sum = (l1.val  + l2.val) + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int sum = l1.val +  carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int sum = l2.val +  carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            l2 = l2.next;
        }
        if(carry!=0){
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        
        return dummyNode.next;
    }
}