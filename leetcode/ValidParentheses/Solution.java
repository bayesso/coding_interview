/**
 * [Question]
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * [Solution]
 * Use a stack. Scan the string. When touching (, [, or {, push it to stack. When touching ), ], }, pops an element from 
 * stack and compare them. If paired, go on; otherwise, return false.
 */


public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> ht = new HashMap<Character, Character>();
        ht.put('(', ')');
        ht.put('[', ']');
        ht.put('{', '}');
        Stack<Character> mystack = new Stack<Character>();
        
        for (int i=0; i<s.length(); i++)
        {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{')
            {
                mystack.push(cur);
            }
            else
            {
                if (mystack.isEmpty())
                {
                    return false;
                }
                
                char a = mystack.pop();
                if (ht.get(a) != cur)
                {
                    return false;
                }
            }
        }
        
        if (mystack.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}