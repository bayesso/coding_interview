/**
 * [Question]
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string. If the last word does not exist, return 0. Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * [Solution]
 * Scan from the end of the string. Set a boolean variable to record the status if touching a word. 
 */


public class Solution {
    public int lengthOfLastWord(String s) {
        boolean isWord = false;
        int p1 = s.length()-1;
        int len_last_word = 0;
        while (p1 >= 0)
        {
            if (s.charAt(p1) != ' ')
            {
                if (!isWord)
                {
                    isWord = true;
                }
                
                if (isWord)
                {
                    len_last_word++;
                }
            }
            else
            {
                if (isWord)
                {
                    break;
                }
            }
            p1--;
        }
        
        return len_last_word;
    }
}