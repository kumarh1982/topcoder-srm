import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TwoRectangles
{
	public String describeIntersection(int[] A, int[] B)
	{
		int minX = Math.max(A[0], B[0]);
        int minY = Math.max(A[1], B[1]);
        int maxX = Math.min(A[2], B[2]);
        int maxY = Math.min(A[3], B[3]);
        if (maxX - minX < 0 || maxY - minY < 0) {
            return "none";
        } else if (maxX - minX > 0 && maxY - minY > 0) {
            return "rectangle";
        } else if (maxX - minX == 0 && maxY - minY == 0) {
            return "point";
        } else {
            return "segment";
        }
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, String p2) {
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
		System.out.print("}");
		System.out.println("]");
		TwoRectangles obj;
		String answer;
		obj = new TwoRectangles();
		long startTime = System.currentTimeMillis();
		answer = obj.describeIntersection(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p2 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p2);
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
		String p2;
		
		// ----- test 0 -----
		p0 = new int[]{0,0,3,2};
		p1 = new int[]{1,1,5,3};
		p2 = "rectangle";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{0,0,5,3};
		p1 = new int[]{1,2,2,3};
		p2 = "rectangle";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{1,1,6,2};
		p1 = new int[]{3,2,5,4};
		p2 = "segment";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{0,1,2,3};
		p1 = new int[]{2,0,5,2};
		p2 = "segment";
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{0,0,1,1};
		p1 = new int[]{1,1,5,2};
		p2 = "point";
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new int[]{1,1,2,2};
		p1 = new int[]{3,1,4,2};
		p2 = "none";
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// 
	// You are given two rectangles in the plane.
	// The sides of each rectangle are parallel to the coordinate axes.
	// Each rectangle is given by the coordinates of its lower left corner and its upper right corner.
	// You are given two int[]s: A and B.
	// A describes the first rectangle: its lower left corner has coordinates (A[0],A[1]) and its upper right corner has coordinates (A[2],A[3]).
	// B describes the second rectangle in the same way.
	// 
	// 
	// Your task is to determine how their intersection looks like.
	// There are four options:
	// 
	// 
	// If the rectangles have a non-zero area in common, return "rectangle".
	// Otherwise, if they have a common line segment with non-zero length, return "segment".
	// Otherwise, if they have a point in common, return "point".
	// Otherwise, return "none" (in all four cases, the quotes are just for clarity).
	// 
	// 
	// DEFINITION
	// Class:TwoRectangles
	// Method:describeIntersection
	// Parameters:int[], int[]
	// Returns:String
	// Method signature:String describeIntersection(int[] A, int[] B)
	// 
	// 
	// NOTES
	// -The Constraints guarantee that both rectangles lie in the first quadrant of the coordinate plane, and each rectangle has a positive area.
	// 
	// 
	// CONSTRAINTS
	// -A will contain exactly 4 elements.
	// -The elements of A will satisfy 0 <= A[0] < A[2] <= 1000 and 0 <= A[1] < A[3] <= 1000.
	// -B will contain exactly 4 elements.
	// -The elements of B will satisfy 0 <= B[0] < B[2] <= 1000 and 0 <= B[1] < B[3] <= 1000.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {0,0,3,2}
	// {1,1,5,3}
	// 
	// Returns: "rectangle"
	// 
	// These two rectangles overlap partially:
	// 
	// 
	// 
	// 
	// 1)
	// {0,0,5,3}
	// {1,2,2,3}
	// 
	// Returns: "rectangle"
	// 
	// The second rectangle is completely inside the first one.
	// 
	// 
	// 
	// 
	// 2)
	// {1,1,6,2}
	// {3,2,5,4}
	// 
	// Returns: "segment"
	// 
	// The second rectangle sits on top of the first one.
	// 
	// 
	// 
	// 
	// 3)
	// {0,1,2,3}
	// {2,0,5,2}
	// 
	// Returns: "segment"
	// 
	// 
	// 
	// 4)
	// {0,0,1,1}
	// {1,1,5,2}
	// 
	// Returns: "point"
	// 
	// 
	// 
	// 5)
	// {1,1,2,2}
	// {3,1,4,2}
	// 
	// Returns: "none"
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
