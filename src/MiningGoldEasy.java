import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

/**
 * SRM 610 DIV 2
 */
public class MiningGoldEasy
{
	public int GetMaximumGold(int N, int M, int[] event_i, int[] event_j)
	{
		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int[] p2, int[] p3, boolean hasAnswer, int p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p3.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p3[i]);
		}
		System.out.print("}");
		System.out.println("]");
		MiningGoldEasy obj;
		int answer;
		obj = new MiningGoldEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.GetMaximumGold(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p4);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p4;
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
		int[] p3;
		int p4;
		
		// ----- test 0 -----
		p0 = 2;
		p1 = 2;
		p2 = new int[]{0};
		p3 = new int[]{0};
		p4 = 4;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 2;
		p1 = 2;
		p2 = new int[]{0,2};
		p3 = new int[]{0,1};
		p4 = 7;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 3;
		p1 = 3;
		p2 = new int[]{0,3,3};
		p3 = new int[]{0,3,0};
		p4 = 15;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 3;
		p1 = 4;
		p2 = new int[]{0,3};
		p3 = new int[]{4,1};
		p4 = 11;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 5;
		p1 = 6;
		p2 = new int[]{0,4,2,5,0};
		p3 = new int[]{3,4,5,6,0};
		p4 = 48;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 557;
		p1 = 919;
		p2 = new int[]{81,509,428,6,448,149,77,142,40,405,109,247};
		p3 = new int[]{653,887,770,477,53,637,201,863,576,393,512,243};
		p4 = 16255;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, true, p4) && all_right;
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
