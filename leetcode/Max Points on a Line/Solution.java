/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

[Solution] Given a point (denoted as origin), do the following:
1. check if any duplicated points (overlapped points) in the rest points. If so, increase the dup_base (record number of duplicated origin)
2. calculate the slopes from origin to all other points
3. find equivalent sets of slopes (firstly sort the slopes and use two-pointer trick to scan equivalent slopes, and update maxP in time)

Note: when the i-th point is set as origin, to only scan the points from i+1 to n, in order to get rid of duplicated counts. 
*/


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution 
{
    public int maxPoints(Point[] points) 
    {
 		int n = points.length;
 		int maxP = 0;
 		ArrayList<Double> slopes = new ArrayList<Double>();
 		for (int i=0; i<n; i++)
 		{
 			int dup_base = 1;
 			double x0 = points[i].x;
 			double y0 = points[i].y;
 			slopes.clear();
 			for (int j=i+1; j<n; j++)
 			{
 				double xx = points[j].x - x0;
 				double yy = points[j].y - y0;
 				if (xx == 0)
 				{
 					if (yy == 0)
 					{
 						dup_base++;
 					}
 					else
 					{	
 						slopes.add(Double.MAX_VALUE);
 					}
 				}
 				else
 				{
 					slopes.add(yy / xx);
 				}
 			}

 			Collections.sort(slopes);

 			if (slopes.size() > 1)
 			{
 				int p1 = 0, p2 = 1;
	 			while (p2 < slopes.size())
	 			{
	 				if (Math.abs(slopes.get(p2) - slopes.get(p1)) > 1e-10)
	 				{
	 					p1++;
	 				}
	 				p2++;

	 				if (p2-p1+dup_base > maxP)
					{
						maxP = p2-p1+dup_base;
					}
	 			}
 			}
 			else
 			{
 				if (dup_base + slopes.size() > maxP)
 				{
 					maxP = dup_base + slopes.size();
 				}
 			}
 		}   

 		return maxP;    
    }
}