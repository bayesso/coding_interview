/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

class ListNode
{
	int key;
	int value;
	ListNode next, previous;
	public ListNode()
	{
		key = 0;
		value = 0;
		next = null;
		previous = null;
	}

	public ListNode(int key, int value)
	{
		this.key = key;
		this.value = value;
		this.next = null;
		this.previous = null;
	}
}

public class LRUCache 
{
    int capacity;
    int size;
    ListNode head, tail;
    HashMap<Integer, ListNode> hm;
    public LRUCache(int capacity) 
    {
        if (capacity < 0)
        {
        	return;
        }

        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.hm = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) 
    {
        if (!hm.containsKey(key))
        {
        	return -1;
        }

        int output = hm.get(key).value;
        if (hm.get(key) == head)
        {
        	return output;
        }

        if (hm.get(key) == tail)
        {
        	ListNode tmp = tail;
        	tail = tail.previous;
        	tmp.previous = null;
        	tail.next = null;
        	tmp.next = head;
        	head.previous = tmp;
        	head = tmp;

        	return output;
        }

        ListNode tmp = hm.get(key);
        tmp.previous.next = tmp.next;
        tmp.next.previous = tmp.previous;
        tmp.previous = null;
        tmp.next = null;
        tmp.next = head;
        head.previous = tmp;
        head = tmp;

        return output;
    }
    
    public void set(int key, int value) 
    {
        if (hm.containsKey(key))
        {
        	ListNode curNode = hm.get(key);
        	curNode.value = value;
        	if (curNode == head)
        	{
        		return;
        	}

        	if (curNode == tail)
        	{
        		tail = tail.previous;
        		tail.next = null;
        		curNode.previous = null;
        		curNode.next = head;
        		head.previous = curNode;
        		head = curNode;
        		return;
        	}

        	curNode.previous.next = curNode.next;
        	curNode.next.previous = curNode.previous;
        	curNode.previous = null;
        	curNode.next = null;
        	curNode.next = head;
        	head.previous = curNode;
        	head = curNode;
        }
        else
        {
        	if (size < capacity)
        	{
        		ListNode curNode = new ListNode(key, value);
        		hm.put(key, curNode);
        		if (head == null)
        		{
        			head = curNode;
        			tail = head;
        		}
        		else
        		{
        			curNode.next = head;
        			head.previous = curNode;
        			head = curNode;
        		}
        		size++;
        	}
        	else
        	{
        		if (head == null)
        		{
        			return;
        		}

        		if (head == tail)
        		{
        			hm.remove(head.key);
        			hm.put(key, head);
        			head.key = key;
        			head.value = value;
        			return;
        		}

        		ListNode curNode = tail;
        		hm.remove(curNode.key);
        		hm.put(key, curNode);
        		tail = tail.previous;
        		curNode.key = key;
        		curNode.value = value;
        		tail.next = null;
        		curNode.previous = null;
        		curNode.next = head;
        		head.previous = curNode;
        		head = curNode;
        	}
        }
    }
}

