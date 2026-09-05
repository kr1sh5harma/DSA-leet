// leet 19
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n<=0) return head;

        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }

        if(n>count){
            return head;
        }

        int target = count-n+1;

        if(target==1){
            return head.next;
        }

        temp = head;
        for(int i=1; i<target-1; i++){
            temp = temp.next;
        }
        temp.next= temp.next.next;

        return head;
    }
}
