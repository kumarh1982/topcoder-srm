import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class CandleTimerEasy
{
	/**
	 * 1. double the len so we don't get half integers
	 * 2. find all pairs shortest paths
	 * 3. enum all lighting schemes, simulate with the paths' length
	 * 			find out the longest time of all paths
	 * 4. get results in hashset
	 * @param  A   [description]
	 * @param  B   [description]
	 * @param  len [description]
	 * @return     [description]
	 */
	public int differentTime(int[] A, int[] B, int[] len)
	{
		return 0;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		CandleTimerEasy obj;
		int answer;
		obj = new CandleTimerEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.differentTime(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p3);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p3;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		all_right = true;
		
		int[] p0;
		int[] p1;
		int[] p2;
		int p3;
		
		// ----- test 0 -----
		p0 = new int[]{0,1};
		p1 = new int[]{1,2};
		p2 = new int[]{10,1};
		p3 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{0,0,0};
		p1 = new int[]{1,2,3};
		p2 = new int[]{1,1,1};
		p3 = 2;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{0,0,0};
		p1 = new int[]{1,2,3};
		p2 = new int[]{1,2,3};
		p3 = 4;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{0,1,1,2,3,3,2,4};
		p1 = new int[]{1,2,3,4,5,6,7,8};
		p2 = new int[]{5,3,2,4,6,8,7,1};
		p3 = 7;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{0,0,0,0};
		p1 = new int[]{1,2,3,4};
		p2 = new int[]{123,456,789,1000};
		p3 = 8;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new int[]{0};
		p1 = new int[]{1};
		p2 = new int[]{1000};
		p3 = 2;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// You have a lot of candles.
	// The candles burn at a uniform rate: if you ignite a candle of length L, it will burn completely in L units of time.
	// You can also ignite a candle at both ends, which makes it burn twice as fast.
	// 
	// 
	// 
	// You have arranged some candles into the shape of a tree.
	// You want to use the tree to measure time.
	// At the beginning, you will ingite some leaves of the tree (all at the same time).
	// Then you will just wait and watch the flames spread across the entire tree.
	// (Whenever a flame reaches an inner node of the tree, it spreads to all branches that meet at that node.)
	// Note that you are not allowed to light new flames during the process.
	// The time you will measure is the time between the moment when you lighted the fire(s) and the moment when the last part of the tree finished burning.
	// 
	// 
	// 
	// You are given a description of the tree as three int[]s: a, b, and len, with N elements each.
	// The nodes of the tree are numbered 0 through N, inclusive.
	// For each valid i, there is a candle between the nodes a[i] and b[i] with length len[i].
	// 
	// 
	// 
	// Compute and return the number of different times you can measure when following the above procedure.
	// 
	// DEFINITION
	// Class:CandleTimerEasy
	// Method:differentTime
	// Parameters:int[], int[], int[]
	// Returns:int
	// Method signature:int differentTime(int[] A, int[] B, int[] len)
	// 
	// 
	// CONSTRAINTS
	// -A will contain between 1 and 19 elements, inclusive.
	// -A, B and len will contain same number of elements.
	// -Each element in A will be between 0 and |A|, inclusive.
	// -Each element in B will be between 0 and |A|, inclusive.
	// -Each element in len will be between 1 and 1000, inclusive.
	// -A, B and len will describe a tree.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {0,1}
	// {1,2}
	// {10,1}
	// 
	// Returns: 2
	// 
	// This tree looks the same as a single candle of length 11. If we light it on one end, we will measure the time 11. If we light it on both ends, we will measure the time 5.5.
	// 
	// 1)
	// {0,0,0}
	// {1,2,3}
	// {1,1,1}
	// 
	// Returns: 2
	// 
	// This time we have 3 ends. If we ignite all of them the time is 1, otherwise the time is 2.
	// 
	// 2)
	// {0,0,0}
	// {1,2,3}
	// {1,2,3}
	// 
	// Returns: 4
	// 
	// We can get 4 different outcomes: 2.5, 3, 4, 5.
	// 
	// 3)
	// {0,1,1,2,3,3,2,4}
	// {1,2,3,4,5,6,7,8}
	// {5,3,2,4,6,8,7,1}
	// 
	// Returns: 7
	// 
	// 
	// 
	// 4)
	// {0,0,0,0}
	// {1,2,3,4}
	// {123,456,789,1000}
	// 
	// Returns: 8
	// 
	// 
	// 
	// 5)
	// {0}
	// {1}
	// {1000}
	// 
	// Returns: 2
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!