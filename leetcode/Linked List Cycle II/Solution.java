/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public ListNode detectCycle(ListNode head) 
    {
    	if (head == null || head.next == null)
    	{
    		return null;
    	}    

    	ListNode p1 = head, p2 = head;
    	while (p2 != null && p2.next != null)
    	{
    		p1 = p1.next;
    		p2 = p2.next.next;

    		if (p1 == p2)
    		{
    			p1 = head;
    			while (p1 != p2)
    			{
    				p1 = p1.next;
    				p2 = p2.next;
    			}

    			return p1;
    		}
    	}

    	return null;
    }
}