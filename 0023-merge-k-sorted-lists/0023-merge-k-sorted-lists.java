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
        if(lists==null || lists.length==0){
            return null;
        }
        int interval = 1;
        while(interval<lists.length){
            for(int i=0;i+interval<lists.length;i+=interval){
                lists[i] = merge(lists[i],lists[i+interval]);
            }
            interval*=2;
        }
        return lists[0];
    }
    ListNode merge(ListNode l,ListNode l1){
        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;
        while(l!=null && l1!=null){
            if(l.val<=l1.val){
            curr.next  = new ListNode(l.val);
            curr = curr.next;
            l = l.next;
            }else{
                curr.next = new ListNode(l1.val);
                curr = curr.next;
                l1 =l1.next;
            }
        }
        if(l!=null){
            curr.next = l; 
        }
        if(l1!=null){
            curr.next = l1;
        }
        return dummyNode.next;
    }
}