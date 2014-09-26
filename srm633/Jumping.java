import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class Jumping
{
	/**
	 * SRM 633
	 * @param  x           [description]
	 * @param  y           [description]
	 * @param  jumpLengths [description]
	 * @return             [description]
	 */
	public String ableToGet(int x, int y, int[] jumpLengths)
	{
		double dist = Math.hypot(x * 1.0, y * 1.0);
		int low, high;
		low = high = jumpLengths[0];
		for (int i = 1; i < jumpLengths.length; ++i) {
			low = Math.abs(low - jumpLengths[i]);
			high += jumpLengths[i];
		}
		return (low <= dist && high >= dist) ? "Able" : "Not able";
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int[] p2, boolean hasAnswer, String p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		Jumping obj;
		String answer;
		obj = new Jumping();
		long startTime = System.currentTimeMillis();
		answer = obj.ableToGet(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p3 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p3);
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
		int[] p2;
		String p3;
		
		// ----- test 0 -----
		p0 = 5;
		p1 = 4;
		p2 = new int[]{2,5};
		p3 = "Able";
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 3;
		p1 = 4;
		p2 = new int[]{4};
		p3 = "Not able";
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 3;
		p1 = 4;
		p2 = new int[]{6};
		p3 = "Not able";
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 0;
		p1 = 1;
		p2 = new int[]{100,100};
		p3 = "Able";
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 300;
		p1 = 400;
		p2 = new int[]{500};
		p3 = "Able";
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 11;
		p1 = 12;
		p2 = new int[]{1,2,3,4,5,6,7,8,9,10};
		p3 = "Able";
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = 11;
		p1 = 12;
		p2 = new int[]{1,2,3,4,5,6,7,8,9,100};
		p3 = "Not able";
		all_right = KawigiEdit_RunTest(6, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
