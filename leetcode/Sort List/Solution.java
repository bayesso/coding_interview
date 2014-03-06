/*
Sort a linked list in O(n log n) time using constant space complexity.

[Solution] This is the list version of merge sort. The tricky part is:
1. Find the middle point of the list 
2. When merging two list to a new list, consider the case of empty head and empty tail. 
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
	public ListNode merge(ListNode h1, ListNode h2)
	{
		ListNode p1 = h1, p2 = h2;
		ListNode h = null, t = null;
		while (p1 != null && p2 != null)
		{
			if (p1.val < p2.val)
			{
				h1 = h1.next;
				p1.next = null;
				if (h == null)
				{
					h = p1;
					t = h;
				}
				else
				{
					t.next = p1;
					t = t.next;
				}
				p1 = h1;
			}
			else
			{
				h2 = h2.next;
				p2.next = null;
				if (h == null)
				{
					h = p2;
					t = h;
				}
				else
				{
					t.next = p2;
					t = t.next;
				}
				p2 = h2;
			}
		}

		if (h1 != null)
		{
			if (h == null)
			{
				h = h1;
			}
			else
			{
				t.next = h1;
			}
		}

		if (h2 != null)
		{
			if (h == null)
			{
				h = h2;
			}
			else
			{
				t.next = h2;
			}
		}

		return h;
	}

    public ListNode sortList(ListNode head) 
    {
    	if (head == null || head.next == null)
		{
			return head;
		}

		ListNode p1 = head, p2 = head;
		while (p2.next != null && p2.next.next != null)
		{
			p1 = p1.next;
			p2 = p2.next.next;
		}

		ListNode head2 = p1.next;
		p1.next = null;
		ListNode h1 = sortList(head);
		ListNode h2 = sortList(head2);

		return merge(h1, h2);    
    }
}


