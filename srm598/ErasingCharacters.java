import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ErasingCharacters
{
	public String simulate(String s)
	{
		StringBuilder sb = new StringBuilder(s);
        int size1, size2;
        do {
            size1 = sb.length();
            int pos = -1;
            for (int i = 1; i < size1; i++) {
                if (sb.charAt(i - 1) == sb.charAt(i)) {
                    pos = i - 1;
                    break;
                }
            }
            if (pos != -1) {
                char c = sb.charAt(pos);
                sb.deleteCharAt(pos);
                sb.deleteCharAt(pos);
            }

            size2 = sb.length();
        } while (size1 > size2);
        return sb.toString();
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		ErasingCharacters obj;
		String answer;
		obj = new ErasingCharacters();
		long startTime = System.currentTimeMillis();
		answer = obj.simulate(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p1 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p1);
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
		
		String p0;
		String p1;
		
		// ----- test 0 -----
		p0 = "cieeilll";
		p1 = "cl";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "topcoder";
		p1 = "topcoder";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "abcdefghijklmnopqrstuvwxyyxwvutsrqponmlkjihgfedcba";
		p1 = "";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "bacaabaccbaaccabbcabbacabcbba";
		p1 = "bacbaca";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "eel";
		p1 = "l";
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
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
