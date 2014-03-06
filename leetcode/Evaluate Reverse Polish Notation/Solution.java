/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * [Solution] Use a stack. 
 */

public class Solution 
{
    public int evalRPN(String[] tokens) 
    {
		int n = tokens.length;
		int res = 0;
		Stack<Integer> mystack = new Stack<Integer>();
		for (int i=0; i<n; i++)
		{
			String cur = tokens[i];
			if (cur.equals("+"))
			{
				int x1 = mystack.pop();
				int x2 = mystack.pop();
				mystack.push(x1 + x2);
			}
			else if (cur.equals("-"))
			{
				int x1 = mystack.pop();
				int x2 = mystack.pop();
				mystack.push(x2 - x1);
			}
			else if (cur.equals("*"))
			{
				int x1 = mystack.pop();
				int x2 = mystack.pop();
				mystack.push(x1 * x2);
			}
			else if (cur.equals("/"))
			{
				int x1 = mystack.pop();
				int x2 = mystack.pop();
				mystack.push(x2 / x1);
			}
			else
			{
				mystack.push(Integer.parseInt(cur));
			}
		}	   

		return mystack.pop();     
    }
}