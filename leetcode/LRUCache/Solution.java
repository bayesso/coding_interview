/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

class ListNode
{
    int key, value;
    ListNode next, previous;
    ListNode()
    {
        key = 0;
        value = 0;
        next = null;
        previous = null;
    }
    ListNode(int key, int value)
    {
        this.key = key;
        this.value = value;
        next = null;
        previous = null;
    }
}

public class LRUCache {
    int size = 0;
    int capacity = 0;
    Map<Integer, ListNode> ht = new HashMap<Integer, ListNode>();
    ListNode head = null, tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int output = -1;
        if (ht.containsKey(key))
        {
            ListNode cur = ht.get(key);
            output = cur.value;
            if (cur != head)
            {
                if (cur == tail)
                {
                    tail = cur.previous;
                    cur.previous.next = null;
                    cur.previous = null;
                    cur.next = head;
                    head.previous = cur;
                    head = cur;
                }
                else
                {
                    cur.previous.next = cur.next;
                    cur.next.previous = cur.previous;
                    cur.previous = null;
                    cur.next = null;
                    cur.next = head;
                    head.previous = cur;
                    head = cur;
                }
            }
        }
        
        return output;
    }
    
    public void set(int key, int value) {
        if (ht.containsKey(key))
        {
            ListNode cur = ht.get(key);
            cur.value = value;
            if (cur != head)
            {
                if (cur == tail)
                {
                    tail = cur.previous;
                    cur.previous.next = null;
                    cur.previous = null;
                    cur.next = head;
                    head.previous = cur;
                    head = cur;
                }
                else
                {
                    cur.previous.next = cur.next;
                    cur.next.previous = cur.previous;
                    cur.previous = null;
                    cur.next = null;
                    cur.next = head;
                    head.previous = cur;
                    head = cur;
                }
            }
        }
        else
        {
            if (size == capacity)
            {
                if (capacity == 1)
                {
                    ht.remove(tail.key);
                    head = null;
                    tail = null;
                    size--;
                }
                else
                {
                    ht.remove(tail.key);
                    ListNode tail_pre = tail.previous;
                    tail_pre.next = null;
                    tail.previous = null;
                    tail = tail_pre;
                    size--;
                }
            }
            
            if (head == null)
            {
                head = new ListNode(key, value);
                tail = head;
            }
            else
            {
                ListNode tmpNode = new ListNode(key, value);
                tmpNode.next = head;
                head.previous = tmpNode;
                head = tmpNode;
            }
            ht.put(key, head);
            size++;
        }
    }
}