import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TheShuttles {
    public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
        int ret = Integer.MAX_VALUE;
        for (int seat = 1; seat <= 100; ++seat) {
            double busCount = 0;
            for (int s : cnt) {
                busCount += Math.ceil(1.0 * s / seat);
            }
            int curr = (int) busCount * (baseCost + seat * seatCost);
            ret = Math.min(ret, curr);
        }
        return ret;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, int p2, boolean hasAnswer, int p3) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p0[i]);
        }
        System.out.print("}" + "," + p1 + "," + p2);
        System.out.println("]");
        TheShuttles obj;
        int answer;
        obj = new TheShuttles();
        long startTime = System.currentTimeMillis();
        answer = obj.getLeastCost(p0, p1, p2);
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
        int p1;
        int p2;
        int p3;

        // ----- test 0 -----
        p0 = new int[] {9};
        p1 = 30;
        p2 = 5;
        p3 = 75;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {9, 4};
        p1 = 15;
        p2 = 100;
        p3 = 1495;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {9, 4};
        p1 = 10;
        p2 = 5;
        p3 = 105;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {51, 1, 77, 14, 17, 10, 80};
        p1 = 32;
        p2 = 40;
        p3 = 12096;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
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