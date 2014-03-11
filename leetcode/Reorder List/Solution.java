/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
	public ListNode reverseList(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode tmp = head.next;
		head.next = null;
		ListNode h1 = reverseList(tmp);
		tmp.next = head;

		return h1;
	}

    public void reorderList(ListNode head) 
    {
        if (head == null || head.next == null)
        {
        	return;
        }

        ListNode p1 = head, p2 = head;
        while (p2.next != null && p2.next.next != null)
        {
        	p1 = p1.next;
        	p2 = p2.next.next;
        }

        ListNode h1 = head;
        ListNode h2 = p1.next;
        p1.next = null;

        h2 = reverseList(h2);

        while (h2 != null)
        {
        	ListNode tmp1 = h1.next, tmp2 = h2.next;
        	h1.next = h2;
        	h1 = tmp1;
        	h2.next = h1;
        	h2 = tmp2;
        }
    }
}