import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ORSolitaireDiv2 {
    public int getMinimum(int[] numbers, int goal) {
        int ret = Integer.MAX_VALUE;
        int size = numbers.length;
        boolean[] canUse = new boolean[size];
        Arrays.fill(canUse, true);
        for (int i = 0; i < size; ++i) {
            int n = numbers[i];
            if ((n ^ (n & goal)) != 0) canUse[i] = false;
        }
        for (int i = 0; i < 31; ++i) {
            if ((goal & (1 << i)) != 0) {
                int cnt = 0;
                for (int ii = 0; ii < size; ++ii) {
                    int n = numbers[ii];
                    if (canUse[ii] && (n & (1 << i)) != 0) cnt++;
                }
                ret = Math.min(cnt, ret);
            }
        }
        return ret;
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
        ORSolitaireDiv2 obj;
        int answer;
        obj = new ORSolitaireDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.getMinimum(p0, p1);
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
        p0 = new int[] {1, 2, 4};
        p1 = 7;
        p2 = 1;
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {1, 2, 4, 7, 8};
        p1 = 7;
        p2 = 2;
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {12571295, 2174218, 2015120};
        p1 = 1;
        p2 = 0;
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {5, 2, 4, 52, 62, 9, 8, 3, 1, 11, 6};
        p1 = 11;
        p2 = 3;
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new int[] {503, 505, 152, 435, 491, 512, 1023, 355, 510, 500, 502, 255, 63, 508, 509, 511, 60, 250, 254, 346};
        p1 = 510;
        p2 = 5;
        all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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