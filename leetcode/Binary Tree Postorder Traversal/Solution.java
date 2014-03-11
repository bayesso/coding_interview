/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution 
{
	/* Recursive way 
    public ArrayList<Integer> postorderTraversal(TreeNode root) 
    {
    	ArrayList<Integer> output = new ArrayList<Integer>();
    	if (root == null)
    	{
    		return output;
    	}

    	output.addAll(postorderTraversal(root.left));
    	output.addAll(postorderTraversal(root.right));
    	output.add(root.val);

    	return output;
    }
    */

    public ArrayList<Integer> postorderTraversal(TreeNode root)
    {
    	ArrayList<Integer> output = new ArrayList<Integer>();
    	if (root == null)
    	{
    		return output;
    	}

    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(root);
    	HashSet<TreeNode> hs = new HashSet<TreeNode>();

    	while (!s.isEmpty())
    	{
    		TreeNode curNode = s.peek();
    		if (hs.contains(curNode))
    		{
    		    s.pop();
    			output.add(curNode.val);
    		}
    		else
    		{
    			if (curNode.right != null)
	    		{
	    			s.push(curNode.right);
	    		}
	    		if (curNode.left != null)
	    		{
	    			s.push(curNode.left);
	    		}
	    		hs.add(curNode);
    		}
    	}

    	return output;
    }
}