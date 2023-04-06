package Intersection_of_Two_Linked_Lists;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        while(currA != currB) {
            currA = (currA == null)? headB : currA.next;
            currB = (currB == null)? headA : currB.next;
        }
        return currA;
    }
}

