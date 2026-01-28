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

// Without taking any extra spaces. Time complexity: O(n)       Space complexity: O(1);
class Solution {
    public int pairSum(ListNode head) {
        ListNode midNode = reverseLinkedList(getMid(head)); // This will give the head to the middle after reversing the LinkedList.

        ListNode startNode = head;
        int maxSum = Integer.MIN_VALUE;
        while(startNode != null && midNode != null){
            int currentSum = startNode.val + midNode.val;
            maxSum = Math.max(maxSum, currentSum);
            startNode = startNode.next;
            midNode = midNode.next;
        }

        return maxSum;
    }
    ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    ListNode reverseLinkedList(ListNode head){
        if(head == null){
            return head;
        }
        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode = head.next;

        while(currentNode != null){
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if(nextNode != null){
                nextNode = nextNode.next;
            }
        }
        head = previousNode;
        return head;
    }
}