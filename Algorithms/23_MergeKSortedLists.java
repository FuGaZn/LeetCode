/**
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        
        ArrayList<ListNode> arlist = new ArrayList<ListNode>();
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                arlist.add(lists[i]);
            }
            
        }
        ListNode ret = new ListNode(0);
        ListNode ret2 = new ListNode(0);
        ret2.next = ret;
        
        while(arlist.size()>0){
            int v1 = arlist.get(0).val;
            int ind = 0;
            for(int i=0;i<arlist.size();i++){
                if(arlist.get(i).val<v1){
                    v1 = arlist.get(i).val;
                    ind = i;
                }
            }    
            ret.next = new ListNode(v1);
            ret = ret.next;
            if(arlist.get(ind).next==null){
                arlist.remove(ind);
            }else{
                arlist.set(ind, arlist.get(ind).next);
            }    
        }
        
        return ret2.next.next;
    }
}