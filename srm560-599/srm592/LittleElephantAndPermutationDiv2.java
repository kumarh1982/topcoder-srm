import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class LittleElephantAndPermutationDiv2 {
    /**
     * srm 592
     *     Treat each pair as a list mapping from 1, 2,.. N to a perm(1, 2, ... N)
     *     Multiply each valid pair with factorial(N)
     * @param  N [description]
     * @param  K [description]
     * @return   [description]
     */
    public long getNumber(int N, int K) {
        int[] fact = new int[12];
        fact[0] = 1;
        for (int i = 1; i < 12; ++i) {
            fact[i] = fact[i - 1] * i;
        }
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = b[i] = i + 1;
        }
        int ret = 0;
        do {
            int s = 0;
            for (int i = 0; i < N; i++) {
                s += Math.max(a[i], b[i]);
            }
            if (s >= K) ret++;
        } while (nextPermutation(a) == 1);
        return 1L * ret * fact[N];
    }

    // get the next permutation in place
    public static int nextPermutation(int[] num) {
        int size = num.length;
        if (size <= 1) return 0;

        // 1.find the first acending order pair from the bottom
        int low = size - 2;
        int high = size - 1;
        while (num[low] >= num[high]) {
            if (low == high - 1) {
                low -= 1;
                high = size - 1;
                if (low < 0) break;
            } else {
                high -= 1;
            }
        }

        // reached end of permutation
        if (low < 0) {
            Arrays.sort(num);
            return 0;
        }

        // 2.swap num[lo] with num[hi] if lo >= 0
        int temp = 0;
        temp = num[low];
        num[low] = num[high];
        num[high] = temp;

        // 3.reverse lo+1 .. end
        low = low + 1;
        high = size - 1;
        while (low < high) {
            temp = num[low];
            num[low] = num[high];
            num[high] = temp;
            low++;
            high--;
        }

        return 1;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, long p2) {
        System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
        System.out.println("]");
        LittleElephantAndPermutationDiv2 obj;
        long answer;
        obj = new LittleElephantAndPermutationDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.getNumber(p0, p1);
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
        long p2;

        // ----- test 0 -----
        p0 = 1;
        p1 = 1;
        p2 = 1L;
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = 2;
        p1 = 1;
        p2 = 4L;
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = 3;
        p1 = 8;
        p2 = 18L;
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 10;
        p1 = 47;
        p2 = 13168189440000L;
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    //
    // This problem statement contains superscripts and/or subscripts. These may not display properly outside the applet.
    //
    //
    //
    //
    // Little Elephant from the Zoo of Lviv likes permutations.
    // A permutation of size N is a sequence (a1, ..., aN) that contains each of the numbers from 1 to N exactly once.
    // For example, (3,1,4,5,2) is a permutation of size 5.
    //
    //
    //
    //
    // Given two permutations A = (a1, ..., aN) and B = (b1, ..., bN), the value magic(A,B) is defined as follows:
    // magic(A,B) = max(a1,b1) + max(a2,b2) + ... + max(aN,bN).
    //
    //
    //
    //
    // You are given the int N.
    // You are also given another int K.
    // Return the number of pairs (A,B) such that both A and B are permutations of size N, and magic(A,B) is greater than or equal to K.
    // (Note that A and B are not required to be distinct.)
    //
    //
    // DEFINITION
    // Class:LittleElephantAndPermutationDiv2
    // Method:getNumber
    // Parameters:int, int
    // Returns:long
    // Method signature:long getNumber(int N, int K)
    //
    //
    // CONSTRAINTS
    // -N will be between 1 and 10, inclusive.
    // -K will be between 1 and 100, inclusive.
    //
    //
    // EXAMPLES
    //
    // 0)
    // 1
    // 1
    //
    // Returns: 1
    //
    // For N=1 the only pair of permutations is ( (1), (1) ).
    // The magic of this pair of permutations is 1, so we count it.
    //
    // 1)
    // 2
    // 1
    //
    // Returns: 4
    //
    // Now there are four possible pairs of permutations. They are shown below, along with their magic value.
    //
    // magic( (1,2), (1,2) ) = 1+2 = 3
    // magic( (1,2), (2,1) ) = 2+2 = 4
    // magic( (2,1), (1,2) ) = 2+2 = 4
    // magic( (2,1), (2,1) ) = 2+1 = 3
    //
    // In all four cases the magic value is greater than or equal to K.
    //
    // 2)
    // 3
    // 8
    //
    // Returns: 18
    //
    // When A = (1,2,3), there are 3 possibilities for B: (2,3,1), (3,1,2) and (3,2,1). For each of the other 5 values of A, it can be shown that there are 3 possibilities for B as well. Therefore the answer is 3*6 = 18.
    //
    // 3)
    // 10
    // 47
    //
    // Returns: 13168189440000
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!