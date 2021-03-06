import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class AstronomicalRecordsEasy {
    public int minimalPlanets(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int ret = n + m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int lcm = lcm(A[i], B[j]);
                int[] aa = new int[n];
                for (int k = 0; k < n; k++) {
                    aa[k] = A[k] * lcm / A[i];
                }
                int[] bb = new int[m];
                for (int k = 0; k < m; k++) {
                    bb[k] = B[k] * lcm / B[j];
                }
                HashSet<Integer> set = new HashSet<Integer>();
                for (int a : aa) {
                    set.add(a);
                }
                for (int b : bb) {
                    set.add(b);
                }
                ret = Math.min(ret, set.size());
            }
        }
        return ret;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    private int gcd(int a, int b) {
        if (b != 0) {
            return gcd(b, a % b);
        } else {
            return a;
        }
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, int p2) {
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
        AstronomicalRecordsEasy obj;
        int answer;
        obj = new AstronomicalRecordsEasy();
        long startTime = System.currentTimeMillis();
        answer = obj.minimalPlanets(p0, p1);
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
        int[] p1;
        int p2;

        // ----- test 0 -----
        p0 = new int[] {1,2,3,4};
        p1 = new int[] {2,3,4,5};
        p2 = 5;
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {1,2,3,4};
        p1 = new int[] {2,4,6,8};
        p2 = 4;
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {1,2,3,5,6,8,9};
        p1 = new int[] {2,4,5,6,7,8,9};
        p2 = 9;
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {1,2,3,4};
        p1 = new int[] {6,7,8,9};
        p2 = 6;
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new int[] {200,500};
        p1 = new int[] {100,200,300,400,600,700,800,900};
        p2 = 9;
        all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
        p1 = new int[] {6,7,8,9,10,11,12,13,14,15};
        p2 = 15;
        all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Fox Ciel found two astronomical records.
    // They both describe the same solar system.
    // In this solar system each planet orbits the sun at some fixed distance, and those distances are distinct.
    // Each of the two records contains a comparison of some of those distances.
    //
    //
    //
    // The first record is a int[] A with x elements.
    // These elements correspond to some x planets in the solar system.
    // The distances at which these planets orbit the sun have the ratio A[0] : A[1] : ... : A[x-1].
    // The planets described by A are ordered by their distance from the sun.
    //
    // (That is, earlier elements of A correspond to planets that are closer to the sun.
    // Thus, the elements of A will always form a strictly increasing sequence.)
    //
    //
    //
    // The second record is a int[] B with y elements.
    // These elements correspond to some y planets in the solar system.
    // The distances at which these planets orbit the sun have the ratio B[0] : B[1] : ... : B[y-1].
    // The planets described by B are also ordered by their distance from the sun.
    //
    //
    //
    // Note that the planets mentioned in a record do not have to be consecutive.
    // For example, if a solar system contains the planets P, Q, R, S, T, and U, it is possible that the first record compares P, R, and S, and the second record compares Q, R, T, and U.
    //
    //
    //
    // We assume that both records are correct.
    // Return the smallest possible total number of planets in the solar system.
    //
    // DEFINITION
    // Class:AstronomicalRecordsEasy
    // Method:minimalPlanets
    // Parameters:int[], int[]
    // Returns:int
    // Method signature:int minimalPlanets(int[] A, int[] B)
    //
    //
    // CONSTRAINTS
    // -A will contain between 2 and 50 elements, inclusive.
    // -B will contain between 2 and 50 elements, inclusive.
    // -Each element in A will be between 1 and 1,000, inclusive.
    // -Each element in B will be between 1 and 1,000, inclusive.
    // -Elements in A will be strictly increasing.
    // -Elements in B will be strictly increasing.
    //
    //
    // EXAMPLES
    //
    // 0)
    // {1,2,3,4}
    // {2,3,4,5}
    //
    // Returns: 5
    //
    // There have to be at least 4 planets, because each record compares 4 of them.
    // There cannot be exactly 4 planets, because 1:2:3:4 is not the same ratio as 2:3:4:5.
    // For example, the orbital radii of the two planets closest to the sun would have to have ratio 1:2 and at the same time ratio 2:3, which is impossible.
    // There can be exactly 5 planets with relative orbital radii 1,2,3,4,5.
    //
    //
    // 1)
    // {1,2,3,4}
    // {2,4,6,8}
    //
    // Returns: 4
    //
    // In this case we can only have 4 stars, because 1:2:3:4 = 2:4:6:8.
    //
    // 2)
    // {1,2,3,5,6,8,9}
    // {2,4,5,6,7,8,9}
    //
    // Returns: 9
    //
    // One optimal solution: 1, 2, 3 ,4 ,5 ,6 ,7, 8, 9.
    //
    // 3)
    // {1,2,3,4}
    // {6,7,8,9}
    //
    // Returns: 6
    //
    // One optimal solution: 3, 6, 7, 8, 9, 12.
    //
    //
    // 4)
    // {200,500}
    // {100,200,300,400,600,700,800,900}
    //
    // Returns: 9
    //
    //
    //
    // 5)
    // {1,2,3,4,5,6,7,8,9,10,11,12}
    // {6,7,8,9,10,11,12,13,14,15}
    //
    // Returns: 15
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
