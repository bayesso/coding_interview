/**
 * [Question]
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * [Solution idea]
 * Consider three cases:
 * (1) 0, 1, 2, 3, 4, 5, 6, 7
 * (2) 6, 7, 0, 1, 2, 3, 4, 5
 * (3) 2, 3, 4, 5, 6, 7, 0, 1
 */

public class Solution {
    public int search(int[] A, int target) {
        int L = 0, R = A.length - 1;
        while (L <= R)
        {
            int M = (L + R) / 2;
            if (target == A[M])
            {
                return M;
            }
            
            if (A[L] <= A[R])
            {
                if (target < A[M])
                {
                    R = M - 1;
                }
                else
                {
                    L = M + 1;
                }
            }
            else
            {
                if (A[M] <= A[R])
                {
                    if (target > A[M] && target <= A[R])
                    {
                        L = M + 1;
                    }
                    else
                    {
                        R = M - 1;
                    }
                }
                else 
                {
                    if (target >= A[L] && target < A[M])
                    {
                        R = M - 1;
                    }
                    else
                    {
                        L = M + 1;
                    }
                }
            }
        }
        
        return -1;
    }
}


