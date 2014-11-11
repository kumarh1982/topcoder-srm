import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TheSimilarNumbers
{
	public int find(int lower, int upper)
	{
        int ret = 0;
        int curr = lower;
        while (curr <= upper) {
            curr = curr * 10;
            curr++;
            ret++;
        }
        return ret;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		TheSimilarNumbers obj;
		int answer;
		obj = new TheSimilarNumbers();
		long startTime = System.currentTimeMillis();
		answer = obj.find(p0, p1);
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
		
		int p0;
		int p1;
		int p2;
		
		// ----- test 0 -----
		p0 = 1;
		p1 = 10;
		p2 = 1;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 5;
		p1 = 511;
		p2 = 3;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 5;
		p1 = 4747;
		p2 = 3;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 1;
		p1 = 1000000;
		p2 = 6;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 10;
		p1 = 10110;
		p2 = 3;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Two positive integers A and B are called similar if A <= 10*B and B <= 10*A. For example, 1 and 10 are similar, but 1 and 11 are not.
	// 
	// You are given ints lower and upper. You must select as many integers as possible so that:
	// 
	// each selected integer is between lower and upper, inclusive;
	// no two selected integers are similar.
	// 
	// Return the maximum number of selected integers.
	// 
	// DEFINITION
	// Class:TheSimilarNumbers
	// Method:find
	// Parameters:int, int
	// Returns:int
	// Method signature:int find(int lower, int upper)
	// 
	// 
	// CONSTRAINTS
	// -upper will be between 1 and 1,000,000, inclusive.
	// -lower will be between 1 and upper, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 1
	// 10
	// 
	// Returns: 1
	// 
	// Any two integers between 1 and 10 are similar. Therefore you may select only 1 number.
	// 
	// 1)
	// 5
	// 511
	// 
	// Returns: 3
	// 
	// You can select 51, 5, and 511.
	// 
	// 2)
	// 5
	// 4747
	// 
	// Returns: 3
	// 
	// 
	// 
	// 3)
	// 1
	// 1000000
	// 
	// Returns: 6
	// 
	// 
	// 
	// 4)
	// 10
	// 10110
	// 
	// Returns: 3
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
