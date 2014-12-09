import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ANDEquation
{
	public int restoreY(int[] A)
	{
		int n = A.length;
        int ret = -1;
        for (int i = 0; i < n; i++) {
            int and = (i == 0) ? A[1] : A[0];
            for (int j = 0; j < n; j++) {
                if (j != i) and &= A[j];
            }
            if (and == A[i]) ret = and;
        }
        return ret;
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		ANDEquation obj;
		int answer;
		obj = new ANDEquation();
		long startTime = System.currentTimeMillis();
		answer = obj.restoreY(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
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
		
		// ----- test 0 -----
		p0 = new int[]{1,3,5};
		p1 = 1;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{31,7};
		p1 = -1;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{31,7,7};
		p1 = 7;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,1};
		p1 = 0;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{191411,256951,191411,191411,191411,256951,195507,191411,192435,191411,191411,195511,191419,191411,256947,191415,191475,195579,191415,191411,191483,191411,191419,191475,256947,191411,191411,191411,191419,256947,191411,191411,191411};
		p1 = 191411;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new int[]{1362,1066,1659,2010,1912,1720,1851,1593,1799,1805,1139,1493,1141,1163,1211};
		p1 = -1;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = new int[]{2,3,7,19};
		p1 = -1;
		all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// An AND-equation is an equation that looks like this:
	// 
	// X[0] AND X[1] AND ... AND X[N-1] = Y
	// 
	// Here X[i] and Y are non-negative integers and the bitwise AND operation is defined in the Notes.
	// 
	// In C++, C#, and Java the operator AND is denoted "&". So for example (P & Q & R) is the bitwise AND of numbers P, Q, and R.
	// In VB the same operator is denoted "And".
	// 
	// You are given a int[] A that contains exactly N+1 elements. Your task is to construct an AND-equation using each element of A exactly once. (That is, N of them will be on the left hand side of the AND-equation and the remaining one will be on the right hand side.) If this is possible, return the value of Y in this AND-equation. If no AND-equation can be constructed, return -1. (It can be shown that for each A there is at most one possible value Y, so the return value is always defined correctly.)
	// 
	// DEFINITION
	// Class:ANDEquation
	// Method:restoreY
	// Parameters:int[]
	// Returns:int
	// Method signature:int restoreY(int[] A)
	// 
	// 
	// NOTES
	// -AND is a binary operation, performed on two numbers in binary notation. First, the shorter number is prepended with leading zeroes until both numbers have the same number of digits (in binary). Then, the result is calculated as follows: for each position where both numbers have 1 in their binary representations, the result also has 1. It has 0 in all other positions.
	// -For example 42 AND 7 is performed as follows. First, the numbers are converted to binary: 42 is 101010 and 7 is 111. Then the shorter number is prepended with leading zeros until both numbers have the same number of digits. This means 7 becomes 000111. Then 101010 AND 000111 = 000010 (the result has ones only in the positions where both numbers have ones). Then the result can be converted back to decimal notation. In this case 000010 = 2, so 42 AND 7 = 2.
	// -One of the ways to calculate the AND of more than two numbers X[0], X[1], ..., X[N-1] is "X[0] AND (X[1] AND (... AND X[N-1]))..))". Since the function is commutative and associative, you can also express it as "X[0] AND X[1] AND ... AND X[N-1]" and group the operands in any way you like.
	// 
	// 
	// CONSTRAINTS
	// -A will contain between 2 and 50 elements, inclusive.
	// -Each element of A will be between 0 and 1048575, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {1, 3, 5}
	// 
	// 
	// Returns: 1
	// 
	// 5 AND 3 = 1
	// 
	// 
	// 1)
	// {31, 7}
	// 
	// 
	// Returns: -1
	// 
	// Clearly, no AND-equation is possible in this case.
	// 
	// 
	// 2)
	// {31, 7, 7}
	// 
	// 
	// Returns: 7
	// 
	// 7 AND 31 = 7
	// 
	// Note that duplicate elements are possible in the input. If an element appears several times in A, it must be used the same number of times in the equation.
	// 
	// 3)
	// {1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,
	//  0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,1}
	// 
	// Returns: 0
	// 
	// Zeros are possible in the input.
	// 
	// 4)
	// {191411,256951,191411,191411,191411,256951,195507,191411,192435,191411,
	//  191411,195511,191419,191411,256947,191415,191475,195579,191415,191411,
	//  191483,191411,191419,191475,256947,191411,191411,191411,191419,256947,
	//  191411,191411,191411}
	// 
	// Returns: 191411
	// 
	// 
	// 
	// 5)
	// {1362,1066,1659,2010,1912,1720,1851,1593,1799,1805,1139,1493,1141,1163,1211}
	// 
	// Returns: -1
	// 
	// 6)
	// {2, 3, 7, 19}
	// 
	// Returns: -1
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!