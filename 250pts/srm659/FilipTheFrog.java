import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class FilipTheFrog
{
	public int countReachableIslands(int[] positions, int L)
	{
		int start = positions[0];
		int result = 1;
		Arrays.sort(positions);
		int pos = 0;
		int n = positions.length;
		for (; pos < n; pos++) {
			if (positions[pos] == start) break;
		}
		int prev = start;
		for (int i = pos + 1; i < n; i++) {
			if (Math.abs(positions[i] - prev) <= L) {
				prev = positions[i];
				result++;
			} else {
				break;
			}
		}
		prev = start;
		for (int i = pos - 1; i >= 0; i--) {
			if (Math.abs(positions[i] - prev) <= L) {
				prev = positions[i];
				result++;
			} else {
				break;
			}
		}
		return result;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		FilipTheFrog obj;
		int answer;
		obj = new FilipTheFrog();
		long startTime = System.currentTimeMillis();
		answer = obj.countReachableIslands(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
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
		int p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new int[]{4,7,1,3,5};
		p1 = 1;
		p2 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{100,101,103,105,107};
		p1 = 2;
		p2 = 5;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{17,10,22,14,6,1,2,3};
		p1 = 4;
		p2 = 7;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{0};
		p1 = 1000;
		p2 = 1;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Filip the Frog lives on a number line. There are islands at some points on the number line. You are given the positions of these islands in the int[] positions.
	// 
	// 
	// Filip starts on the island located at positions[0]. His maximal jump length is L, which means that he can jump to any island that is within a distance of L (inclusive) from his current location. Filip can't jump to a point on the number line that doesn't contain an island. He can make an unlimited number of jumps.
	// 
	// 
	// An island is reachable if Filip can get to it through some sequence of jumps. Please find and return the number of reachable islands.
	// 
	// DEFINITION
	// Class:FilipTheFrog
	// Method:countReachableIslands
	// Parameters:int[], int
	// Returns:int
	// Method signature:int countReachableIslands(int[] positions, int L)
	// 
	// 
	// NOTES
	// -If two islands are located at points A and B on the number line, then the distance between them is |A - B|.
	// 
	// 
	// CONSTRAINTS
	// -positions will contain between 1 and 50 elements, inclusive.
	// -Each element of positions will be between 0 and 1000, inclusive.
	// -The elements of positions will be distinct.
	// -L will be between 1 and 1000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {4, 7, 1, 3, 5}
	// 1
	// 
	// Returns: 3
	// 
	// Filip starts at position 4 and his maximal jump length is 1. He can reach the islands at positions 3, 4, and 5.
	// 
	// 1)
	// {100, 101, 103, 105, 107}
	// 2
	// 
	// Returns: 5
	// 
	// Here he can reach all 5 islands.
	// 
	// 2)
	// {17, 10, 22, 14, 6, 1, 2, 3}
	// 4
	// 
	// Returns: 7
	// 
	// 
	// 
	// 3)
	// {0}
	// 1000
	// 
	// Returns: 1
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!