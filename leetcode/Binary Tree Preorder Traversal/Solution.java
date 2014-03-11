/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

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
    public ArrayList<Integer> preorderTraversal(TreeNode root) 
    {
    	ArrayList<Integer> output = new ArrayList<Integer>();
    	if (root == null)
    	{
    		return output;
    	}    

    	output.add(root.val);
    	output.addAll(preorderTraversal(root.left));
    	output.addAll(preorderTraversal(root.right));

    	return output;

    }
*/

    public ArrayList<Integer> preorderTraversal(TreeNode root) 
    {
    	ArrayList<Integer> output = new ArrayList<Integer>();
    	if (root == null)
    	{
    		return output;
    	}    

    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(root);
    	while (!s.isEmpty())
    	{
    		TreeNode curNode = s.pop();
    		output.add(curNode.val);
    		if (curNode.right != null)
    		{
    			s.push(curNode.right);
    		}
    		if (curNode.left != null)
    		{
    			s.push(curNode.left);
    		}
    	}

    	return output;

    }
}