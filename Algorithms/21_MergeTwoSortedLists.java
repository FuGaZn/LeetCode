/**
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)    return l2;
        if(l2==null)    return l1;
        
        ListNode ret = new ListNode(0);
        ListNode ret2 = new ListNode(0);
        ret2.next = ret;
        
        while(l1!=null||l2!=null){
            int v1=0,v2=0;
            v1 = (l1==null)?Integer.MAX_VALUE:l1.val;
            v2 = (l2==null)?Integer.MAX_VALUE:l2.val;
            int val = (v1>=v2)?v2:v1;
            ret.next = new ListNode(val);
            if(val==v1){
                l1=l1.next;
            }else if(val==v2){
                l2=l2.next;
            }
            ret = ret.next;
        }
        return ret2.next.next;
    }
}
