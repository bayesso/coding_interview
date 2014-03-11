/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]

 */

public class Solution 
{
	public boolean isPalindrome(String s)
	{
		int L = 0, R = s.length()-1;
		while (L < R)
		{
			if (s.charAt(L) != s.charAt(R))
			{
				return false;
			}
			L++;
			R--;
		}

		return true;
	}

	public ArrayList<ArrayList<String>> helper(String s, int R)
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		if (R < 0)
		{
			output.add(new ArrayList<String>());
			return output;
		}

		for (int i=0; i<=R; i++)
		{
			String curStr = s.substring(i+1, R+1);
			if (isPalindrome(curStr))
			{
				ArrayList<ArrayList<String>> tmp = helper(s, i);
				for (ArrayList<String> curList : tmp)
				{
					curList.add(curStr);
					output.add(curList);
				}
			}
		}
		
		return output;
	}

    public ArrayList<ArrayList<String>> partition(String s) 
    {
    	return helper(s, s.length()-1);
    }
}