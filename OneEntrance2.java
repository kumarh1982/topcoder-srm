import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

/**
 * srm654
 */
public class OneEntrance2 {
	public int count(int[] a, int[] b, int s) {
		int n = a.length + 1;
		int[][] dist = new int[n][n];
		for (int[] arr : dist) {
			Arrays.fill(arr, 100);
		}
		for (int i = 0; i < n; i++) {
			dist[i][i] = 0;
		}
		for (int i = 0; i < a.length; i++) {
			dist[a[i]][b[i]] = dist[b[i]][a[i]] = 1;
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int[] perm = new int[n];
		for (int i = 0; i < n; i++) {
			perm[i] = i;
		}
		int result = 0;
		do {
			int ok = 1;
			OUTER: for (int i = 0; i < perm.length; i++) {
				for (int j = i + 1; j < perm.length; j++) {
					int x = perm[i], y = perm[j];
					// no back edge in dfs tree
					if (dist[s][x] + dist[x][y] == dist[s][y]) {
						ok = 0;
						break OUTER;
					}
				}
			}
			result += ok;
		} while (nextPermutation(perm) != 0);
		return result;
	}
	/**
	 * get the next permutation in place
	 * @param  num  array of integer
	 * @return int  zero if reached end of perm, one if in middle
	 */
	public int nextPermutation(int[] num) {
		int size = num.length;
		if (size <= 1) return 0;

		// 1.find the first ascending order pair from the bottom
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
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int p2, boolean hasAnswer, int p3) {
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
		System.out.print("}" + "," + p2);
		System.out.println("]");
		OneEntrance2 obj;
		int answer;
		obj = new OneEntrance2();
		long startTime = System.currentTimeMillis();
		answer = obj.count(p0, p1, p2);
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
		int[] p1;
		int p2;
		int p3;

		// ----- test 0 -----
		p0 = new int[] {0, 1, 2};
		p1 = new int[] {1, 2, 3};
		p2 = 0;
		p3 = 1;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new int[] {0, 1, 2};
		p1 = new int[] {1, 2, 3};
		p2 = 2;
		p3 = 3;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new int[] {0, 0, 0, 0};
		p1 = new int[] {1, 2, 3, 4};
		p2 = 0;
		p3 = 24;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new int[] {7, 4, 1, 0, 1, 1, 6, 0};
		p1 = new int[] {6, 6, 2, 5, 0, 3, 8, 4};
		p2 = 4;
		p3 = 896;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new int[] {};
		p1 = new int[] {};
		p2 = 0;
		p3 = 1;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------

		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	//
	// There are N rooms in Maki's new house.
	// The rooms are numbered from 0 to N-1.
	// Some pairs of rooms are connected by bidirectional passages.
	// The passages have the topology of a tree.
	// That is, there are exactly N-1 of them and it is possible to go from any room to any other room by following some sequence of passages.
	//
	//
	// You are given two int[]s a and b that describe the passages.
	// For each valid i, there is a passage that connects the rooms a[i] and b[i].
	// You are also given an int s.
	// The house has exactly one entrance from the outside, and the entrance leads to the room s.
	//
	//
	// Niko is helping Maki move into the new house.
	// Maki has exactly N pieces of furniture.
	// The pieces are numbered from 0 to N-1.
	// Niko will carry them into the house in this order.
	// Each piece of furniture must be placed into a different room.
	// Maki does not care which piece goes where, each of the N! permutations is allowed.
	//
	//
	// However, not all of those N! permutations are actually possible.
	// This is because the furniture is large.
	// As soon as a room contains a piece of furniture, it is impossible to move other pieces through this room.
	// Thus, Niko must place the furniture carefully.
	// Formally, she can place a new piece of furniture into the room x if and only if all rooms on the (unique) path between s and x, including s and x, are still empty.
	// Niko is smart and she will always place the furniture in such a way that she never gets stuck.
	// Thus, at the end each of Maki's rooms will contain exactly one piece of furniture.
	//
	//
	// Calculate and return the number of ways how the furniture can be arranged in Maki's house at the end.
	//
	//
	// DEFINITION
	// Class:OneEntrance2
	// Method:count
	// Parameters:int[], int[], int
	// Returns:int
	// Method signature:int count(int[] a, int[] b, int s)
	//
	//
	// CONSTRAINTS
	// -N will be between 1 and 9, inclusive.
	// -a and b will contain exactly N-1 elements each.
	// -Each element of a and b will be between 0 and N-1, inclusive.
	// -The graph described by a and b will be a tree.
	// -s will be between 0 and N-1, inclusive.
	//
	//
	// EXAMPLES
	//
	// 0)
	// {0, 1, 2}
	// {1, 2, 3}
	// 0
	//
	// Returns: 1
	//
	// There is only one solution: Niko must fill the rooms in the order {3,2,1,0}.
	// Thus, piece number 0 will end in room 3, piece number 1 in room 2, and so on.
	//
	// 1)
	// {0, 1, 2}
	// {1, 2, 3}
	// 2
	//
	// Returns: 3
	//
	// In this case Niko can choose one of three orders: {3,0,1,2}, {0,3,1,2}, or {0,1,3,2}.
	// Note that the room with the entrance (in this case, room 2) always gets the last piece of furniture.
	//
	// 2)
	// {0, 0, 0, 0}
	// {1, 2, 3, 4}
	// 0
	//
	// Returns: 24
	//
	//
	//
	// 3)
	// {7, 4, 1, 0, 1, 1, 6, 0}
	// {6, 6, 2, 5, 0, 3, 8, 4}
	// 4
	//
	// Returns: 896
	//
	//
	//
	// 4)
	// {}
	// {}
	// 0
	//
	// Returns: 1
	//
	// Maki's new house has only one room.
	//
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!