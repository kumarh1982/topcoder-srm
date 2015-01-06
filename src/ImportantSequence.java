import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ImportantSequence
{
	public int getCount(int[] B, String operators)
	{
		int n = B.length;
		int INF = (int) 1e9;
		boolean[] plusX = new boolean[n + 1];
		long[] coef = new long[n + 1];
		plusX[0] = true;
		coef[0] = 0;
		for (int i = 1; i < n; i++) {
			// build up inequality

		}
		long max = INF, min = 0;
		for (int i = 0; i <= n; i++) {
			// determin max and min from inequality

		}

		if (min >= max) {
			return -1;
		} else {
			return (int) (max - min - 1) % ;
		}
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, String p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "\"" + p1 + "\"");
		System.out.println("]");
		ImportantSequence obj;
		int answer;
		obj = new ImportantSequence();
		long startTime = System.currentTimeMillis();
		answer = obj.getCount(p0, p1);
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
		String p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new int[]{3,-1,7};
		p1 = "+-+";
		p2 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1};
		p1 = "-";
		p2 = -1;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{1};
		p1 = "+";
		p2 = 0;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{10};
		p1 = "+";
		p2 = 9;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{540,2012,540,2012,540,2012,540};
		p1 = "-+-+-+-";
		p2 = 1471;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// 
	// This problem statement contains superscripts and/or subscripts. It may not display properly outside the applet.
	// 
	// Little Rudolph had an important sequence of positive integers. The sequence consisted of N positive integers a0, a1, .., aN-1.
	// 
	// Rudolph wrote the sequence onto the blackboard in the classroom. While Rudolph had gone out, little Arthur came into the classroom and saw the sequence. Arthur likes to play with numbers as much as he likes to give his friends puzzles. So he did the following:
	// 
	// First, he wrote a '+' or a '-' between each pair of consecutive numbers (possibly using different signs for different pairs of numbers).
	// 	
	// Next, for each sign he computed the result of the corresponding operation and wrote it under the sign.
	// I.e., if he used the '+' sign between ai and ai+1, he would write the sum ai+ai+1 under this '+' sign.
	// Similarly, if he used the '-' sign between ai and ai+1, he would write the difference ai-ai+1. In this way he obtained a new sequence of N-1 numbers b0, b1, .., bN-2.
	// Finally, he erased the original sequence. Now there was only the operator sequence o0, o1, .., oN-2 and the resulting number sequence b0, b2, .., bN-2 left on the blackboard.
	// 
	// For example, if the original sequence was {1, 2, 3, 4}, and Arthur wrote operators {+, -, +}, then the content of the blackboard changed like this:
	// 
	// 1   2   3   4    ->    1 + 2 - 3 + 4    ->    1 + 2 - 3 + 4    ->     +  -  +
	//                                                 3  -1   7             3 -1  7
	// 
	// When Rudolph returned, he was shocked as his important sequence had disappeared. Arthur quickly told him what operations he had performed and that Rudolph has to simply reconstruct the orginal sequence.
	// 
	// Unfortunately, little Arthur did not realize that it is not necessarily possible to determine the original sequence uniquely. For example, both original sequences {1, 2, 3, 4} and {2, 1, 2, 5} lead to the same sequence {3, -1, 7} when operator sequence is {+, -, +}.
	// 
	// The only thing Rudolph remembers about his original sequence is that all the integers were positive. Rudolph now wants to count all sequences of positive integers that match the blackboard. You are given int[] B and String operators  both containing N-1 elements. The i-th element of B is the number bi and i-th element of operators will be '+' or '-', meaning that the i-th operator is + or -, respectively. Return the number of different positive integer sequences A that lead to sequence B when operators operators are used in the way described. If there are infinitely many such sequences, return -1. Note that there may be test cases where no valid sequence A exists. For such test cases the correct return value is 0.
	// 
	// DEFINITION
	// Class:ImportantSequence
	// Method:getCount
	// Parameters:int[], String
	// Returns:int
	// Method signature:int getCount(int[] B, String operators)
	// 
	// 
	// NOTES
	// -It is guaranteed that the correct answer will always fit into the 32-bit signed integer type.
	// -The integer 0 (zero) is not positive. It may not occur in Rudolph's original sequence.
	// 
	// 
	// CONSTRAINTS
	// -B will contain between 1 and 50 elements, inclusive.
	// -operators will contain the same number of characters as the number of elements in B.
	// -Each element of B will be between -1000000000 (-109) and 1000000000 (109), inclusive.
	// -Each character in operators will be either '+' or '-' (quotes for clarity).
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {3, -1, 7}
	// "+-+"
	// 
	// Returns: 2
	// 
	// From the problem statement.
	// 
	// 1)
	// {1}
	// "-"
	// 
	// Returns: -1
	// 
	// There are infinitely many pairs of positive integers that differ by one.
	// 
	// 2)
	// {1}
	// "+"
	// 
	// Returns: 0
	// 
	// Note that all numbers ai have to be positive integers.
	// 
	// 3)
	// {10}
	// "+"
	// 
	// Returns: 9
	// 
	// 4)
	// {540, 2012, 540, 2012, 540, 2012, 540}
	// "-+-+-+-"
	// 
	// Returns: 1471
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
