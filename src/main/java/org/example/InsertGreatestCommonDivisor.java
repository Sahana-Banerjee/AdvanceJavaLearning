package org.example;

/**
 * Given the head of a linked list head, in which each node contains an integer value.
 *
 * Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
 *
 * Return the linked list after insertion.
 *
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [18,6,10,3]
 * Output: [18,6,6,2,10,1,3]
 * Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes (nodes in blue are the inserted nodes).
 * - We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
 * - We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
 * - We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
 * There are no more adjacent nodes, so we return the linked list.
 */
public class InsertGreatestCommonDivisor {

    class ListNode {
        ListNode next;
        int val;
        ListNode(){};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; next = next; }
    }
    public ListNode insertGCDNode(ListNode head){
        ListNode op = head;
        while(head.next!=null){
            int nextVal = head.next.val;
            int currVal = head.val;
            int gcd = findGcd(currVal, nextVal);

            ListNode GNode = new ListNode();
            GNode.next = head.next;
            head.next = GNode;
            GNode.val = gcd;

            head = GNode.next;
        }
        return op;
    }

    int findGcd(int a, int b){
        int r = Math.min(a,b);
        while(r > 0){
            if(a%r==0 && b%r==0){
                break;
            }
            r--;
        }
        return r;
    }

    /*ListNode findGcd(ListNode curr, ListNode nxt){
        ListNode head = curr;
        int r = Math.min(curr.val, nxt.val);
        while(r>0){
            if(curr.val % r == 0 && nxt.val % r == 0)
                break;
            r--;
        }
        ListNode gnode = new ListNode(r, nxt);
        curr = nxt;
        nxt=gnode.next;
        if(nxt != null)
            findGcd(curr, nxt);
        return head;
    } Stackoverflow here , need to fix*/
}

