/**
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

示例:给定 1->2->3->4, 你应该返回 2->1->4->3.

说明:
	你的算法只能使用常数的额外空间。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
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
    public ListNode swapPairs(ListNode head) {
        if(head == null||head.next==null)   return head;
        ListNode ret = new ListNode(0);
        ListNode ret2 = new ListNode(0);
        ret2.next = ret;
        while(head!=null&&head.next!=null){
            ListNode l1 = head, l2 = head.next;
            l1.next = l2.next;
            l2.next = l1;
            ret.next = l2;
            ret = ret.next.next;
            head = head.next;
        }
        return ret2.next.next;
    }
}