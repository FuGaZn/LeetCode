/**
给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

说明 :
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
 
//大概思路：用一个大小为k的数组把每一轮需要翻转的结点存起来，数组值依次向前叠加。则数组的最后一个值即为翻转后的部分链表
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null||!this.notNull(k,head))   return head;
        ListNode ret = new ListNode(0);
        ListNode ret2 = new ListNode(0);
        ret2.next = ret;
        while(this.notNull(k, head)){
            ListNode[] nodes = new ListNode[k];
            for(int i=0;i<k;i++){
                nodes[i] = this.getNodeK(i,head);
            }
            nodes[0].next = nodes[k-1].next;
            for(int i=1;i<k;i++){
                nodes[i].next = nodes[i-1];
            }
            ret.next = nodes[k-1];
            int m = k;
            while(m>0){
                m--;
                ret = ret.next;
            }
            head = head.next;
        }
        return ret2.next.next;
    }
    public ListNode getNodeK(int k, ListNode head){
        while(k>0){
            k--;
            head = head.next;
        }
        return head;
    }
    public boolean notNull(int k, ListNode head){
        while(k>0){
            if(head==null){
                return false;
            }else{
                k--;
                head = head.next;
            }
        }
        return true;
    }
}