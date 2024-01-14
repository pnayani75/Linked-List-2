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
//TC o(m+n)
//SC o(1)
public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode lisA = headA;
        ListNode lisB = headB;
        int cntA = 0, cntB=0;
        while(lisA != null){
            cntA++;
            lisA = lisA.next;
        }
        while(lisB != null){
            cntB++;
            lisB = lisB.next;
        }
        int diff = cntA>cntB ? cntA-cntB : cntB-cntA;
        if(cntA>cntB){
            while(diff>0){
                if(headA == null) return null;
                headA = headA.next;
                diff--;
            }
        } else {
            while(diff>0){
                if(headB == null) return null;
                headB = headB.next;
                diff--;
            }
        }

        while(headA != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
