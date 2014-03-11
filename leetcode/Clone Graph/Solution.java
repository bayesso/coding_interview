/*

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
Have you been asked this question in an interview?  Yes
Discuss



*/


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution 
{
	public void helper(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> hm)
	{
		if (hm.containsKey(node))
		{
			return;
		}

		hm.put(node, new UndirectedGraphNode(node.label));
		for (UndirectedGraphNode curNode : node.neighbors)
		{
			helper(node, curNode);
		}
	}
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
    {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        helper(node, hm);

        for (UndirectedGraphNode oldNode : hm.keySet())
        {
        	UndirectedGraphNode newNode = hm.get(oldNode);
        	for (UndirectedGraphNode ss : oldNode)
        	{
        		newNode.neighbors.add(hm.get(ss));
        	}
        }

        return hm.get(node);
    }
}




