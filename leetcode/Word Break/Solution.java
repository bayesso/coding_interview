/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution 
{
	public boolean helper(String s, Set<String> dict, int R, int[] x)
	{
		if (R < 0)
		{
			return true;
		}

		for (int i=0; i<=R; i++)
		{
			String rStr = s.substring(i, R+1);
			if (dict.contains(rStr))
			{
				if (x[i] == 0)
				{
					boolean isTrue = helper(s, dict, i-1, x);
					if (isTrue)
					{
					    x[i] = 1;
					}
					else
					{
					    x[i] = -1;
					}
				}
				
				if (x[i] == 1)
				{
					return true;
				}
			}
		}

		return false;
	}
    public boolean wordBreak(String s, Set<String> dict) 
    {
    	int[] x = new int[s.length()];
    	return helper(s, dict, s.length()-1, x);
    }
}

