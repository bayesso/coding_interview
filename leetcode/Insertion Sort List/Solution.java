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

public class Solution 
{
    public ListNode insertionSortList(ListNode head) 
    {
    	if (head == null || head.next == null)
    	{
    		return head;
    	}    

    	ListNode tmp1 = head.next;
    	head.next = null;
    	ListNode h = head;
    	head = tmp1;

    	while (head != null)
    	{
    		ListNode tmp2 = head.next;
    		head.next = null;
    		if (head.val < h.val)
    		{
    			head.next = h;
    			h = head;
    		}
    		else
    		{
    			ListNode p = h;
    			while (p.next != null && p.next.val <= head.val)
    			{
    				p = p.next;
    			}

    			ListNode tmp3 = p.next;
    			p.next = head;
    			head.next = tmp3;
    		}
    		head = tmp2;
    	}

    	return h;
    }
}