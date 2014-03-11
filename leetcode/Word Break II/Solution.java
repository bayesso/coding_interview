/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

public class Solution 
{
	public ArrayList<String> helper(String s, Set<String> dict, int R)
	{
		ArrayList<String> output = new ArrayList<String>();
		if (R < 0)
		{
			return output;
		}

		for (int i=0; i<=R; i++)
		{
			String curStr = s.substring(i, R+1);
			if (dict.contains(curStr))
			{
			    if (i==0)
			    {
			        output.add(curStr);
			    }
			    else
			    {
    				ArrayList<String> tmp = helper(s, dict, i-1);
    				for (String str : tmp)
    				{
    					output.add(str + " " + curStr);
    				}
			    }
			}
		}

		return output;
	}
    public ArrayList<String> wordBreak(String s, Set<String> dict) 
    {
        return helper(s, dict, s.length()-1);
    }
}