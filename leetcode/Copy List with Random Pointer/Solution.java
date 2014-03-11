/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution 
{
    public RandomListNode copyRandomList(RandomListNode head) 
    {
    	HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode p = head;
    	while (p != null)
    	{
    		hm.put(p, new RandomListNode(p.label));
    		p = p.next;
    	}
    	hm.put(null, null);

    	p = head;
    	while (p != null)
    	{
    		hm.get(p).next = hm.get(p.next);
    		hm.get(p).random = hm.get(p.random);
    		p = p.next;
    	}

    	return hm.get(head);
    }
} 