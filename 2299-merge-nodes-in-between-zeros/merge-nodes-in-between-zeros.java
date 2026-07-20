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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans=new ListNode();
        ListNode tempAns=ans;

        if(head==null) return ans;

        ListNode curr=head.next; // skippingthe first 0
        int sum=0;

        while(curr!=null){
            if(curr.val==0){
                tempAns.next=new ListNode(sum);
                tempAns=tempAns.next;
                sum=0;
            }
            else{
                sum+=curr.val;
            }
            curr=curr.next;
        }
        return ans.next;
    }
}