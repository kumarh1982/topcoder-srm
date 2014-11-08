public class GooseInZooDivTwo {
    class DisjointSet {
        int size;
        int[] parent, rank;

        public DisjointSet(int size) {
            this.size = size;
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int size() {
            return this.size;
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int i, int j) {
            int p1 = find(i);
            int p2 = find(j);
            if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            } else {
                parent[p2] = p1;
                if (rank[p1] == rank[p2]) rank[p1] += 1;
            }
        }

        public int countSets() {
            HashSet<Integer> s = new HashSet<Integer>();
            for (int i = 0; i < size; i++) {
                s.add(parent[i]);
            }
            return s.size();
        }
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int dist(Point p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }

    public int count(String[] field, int dist) {
        int n = field.length;
        int m = field[0].length();
        ArrayList<Point> pts = new ArrayList<Point>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (field[i].charAt(j) == 'v') {
                    pts.add(new Point(j, i));
                }
            }
        }
        if (pts.isEmpty()) {
            return 0;
        } else {
            DisjointSet dset = new DisjointSet(pts.size());
            for (int iter = 0; iter < pts.size(); iter++) {
                for (int i = 0; i < pts.size(); i++) {
                    for (int j = 0; j < pts.size(); j++) {
                        if (pts.get(i).dist(pts.get(j)) <= dist) {
                            dset.union(i, j);
                        }
                    }
                }
            }
            int ct = dset.countSets();
            System.out.format("Count %d\n", ct);
            BigInteger r = BigInteger.ONE;
            BigInteger MOD = new BigInteger("1000000007");
            r = r.shiftLeft(ct).subtract(BigInteger.ONE).mod(MOD);

            return r.intValue();
        }

    }


    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, int p2) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p0[i] + "\"");
        }
        System.out.print("}" + "," + p1);
        System.out.println("]");
        GooseInZooDivTwo obj;
        int answer;
        obj = new GooseInZooDivTwo();
        long startTime = System.currentTimeMillis();
        answer = obj.count(p0, p1);
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

        String[] p0;
        int p1;
        int p2;

        // ----- test 0 -----
        p0 = new String[]{"vvv"};
        p1 = 0;
        p2 = 7;
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new String[]{"."};
        p1 = 100;
        p2 = 0;
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new String[]{"vvv"};
        p1 = 1;
        p2 = 1;
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new String[]{"v.v..................v............................", ".v......v..................v.....................v", "..v.....v....v.........v...............v......v...", ".........vvv...vv.v.........v.v..................v", ".....v..........v......v..v...v.......v...........", "...................vv...............v.v..v.v..v...", ".v.vv.................v..............v............", "..vv.......v...vv.v............vv.....v.....v.....", "....v..........v....v........v.......v.v.v........", ".v.......v.............v.v..........vv......v.....", "....v.v.......v........v.....v.................v..", "....v..v..v.v..............v.v.v....v..........v..", "..........v...v...................v..............v", "..v........v..........................v....v..v...", "....................v..v.........vv........v......", "..v......v...............................v.v......", "..v.v..............v........v...............vv.vv.", "...vv......v...............v.v..............v.....", "............................v..v.............." +
                "...v", ".v.............v.......v..........................", "......v...v........................v..............", ".........v.....v..............vv..................", "................v..v..v.........v....v.......v....", "........v.....v.............v......v.v............", "...........v....................v.v....v.v.v...v..", "...........v......................v...v...........", "..........vv...........v.v.....................v..", ".....................v......v............v...v....", ".....vv..........................vv.v.....v.v.....", ".vv.......v...............v.......v..v.....v......", "............v................v..........v....v....", "................vv...v............................", "................v...........v........v...v....v...", "..v...v...v.............v...v........v....v..v....", "......v..v.......v........v..v....vv..............", "...........v..........v........v.v................", "v.v......v................v....................v..", ".v........v............................." +
                "...v......", "............................v...v.......v.........", "........................vv.v..............v...vv..", ".......................vv........v.............v..", "...v.............v.........................v......", "....v......vv...........................v.........", "....vv....v................v...vv..............v..", "..................................................", "vv........v...v..v.....v..v..................v....", ".........v..............v.vv.v.............v......", ".......v.....v......v...............v.............", "..v..................v................v....v......", ".....v.....v.....................v.v......v......."};
        p1 = 3;
        p2 = 797922654; // ct is 51
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Crow Keith is looking at the goose cage in the zoo.
    // The bottom of the cage is divided into a grid of square cells.
    // There are some birds sitting on those cells (with at most one bird per cell).
    // Some of them are geese and all the others are ducks.
    //
    // Keith wants to know which birds are geese.
    // He knows the following facts about them:
    //
    // There is at least one goose in the cage.
    // Each bird within Manhattan distance dist of any goose is also a goose.
    //
    //
    // You are given a String[] field and the int dist.
    // The array field describes the bottom of the cage.
    // Each character of each element of field describes one of the cells.
    // The meaning of individual characters follows.
    //
    // The character 'v' represents a cell that contains a bird.
    // The character '.' represents an empty cell.
    //
    //
    // Return the number of possible sets of geese in the cage, modulo 1,000,000,007.
    // Note that for some of the test cases there can be no possible sets of geese.
    //
    // DEFINITION
    // Class:GooseInZooDivTwo
    // Method:count
    // Parameters:String[], int
    // Returns:int
    // Method signature:int count(String[] field, int dist)
    //
    //
    // NOTES
    // -The Manhattan distance between cells (a,b) and (c,d) is |a-c| + |b-d|, where || denotes absolute value. In words, the Manhattan distance is the smallest number of steps needed to get from one cell to the other, given that in each step you can move to a cell that shares a side with your current cell.
    //
    //
    // CONSTRAINTS
    // -field will contain between 1 and 50 elements, inclusive.
    // -Each element of field will contain between 1 and 50 characters, inclusive.
    // -Each element of field will contain the same number of characters.
    // -Each character of each element of field will be 'v' or '.'.
    // -dist will be between 0 and 100, inclusive.
    //
    //
    // EXAMPLES
    //
    // 0)
    // {"vvv"}
    // 0
    //
    // Returns: 7
    //
    // There are seven possible sets of positions of geese: "ddg", "dgd", "dgg", "gdd", "gdg", "ggd", "ggg" ('g' are geese and 'd' are ducks).
    //
    // 1)
    // {"."}
    // 100
    //
    // Returns: 0
    //
    // The number of geese must be positive, but there are no birds in the cage.
    //
    // 2)
    // {"vvv"}
    // 1
    //
    // Returns: 1
    //
    //
    //
    // 3)
    // {"v.v..................v............................"
    // ,".v......v..................v.....................v"
    // ,"..v.....v....v.........v...............v......v..."
    // ,".........vvv...vv.v.........v.v..................v"
    // ,".....v..........v......v..v...v.......v..........."
    // ,"...................vv...............v.v..v.v..v..."
    // ,".v.vv.................v..............v............"
    // ,"..vv.......v...vv.v............vv.....v.....v....."
    // ,"....v..........v....v........v.......v.v.v........"
    // ,".v.......v.............v.v..........vv......v....."
    // ,"....v.v.......v........v.....v.................v.."
    // ,"....v..v..v.v..............v.v.v....v..........v.."
    // ,"..........v...v...................v..............v"
    // ,"..v........v..........................v....v..v..."
    // ,"....................v..v.........vv........v......"
    // ,"..v......v...............................v.v......"
    // ,"..v.v..............v........v...............vv.vv."
    // ,"...vv......v...............v.v..............v....."
    // ,"............................v..v.................v"
    // ,".v.............v.......v.........................."
    // ,"......v...v........................v.............."
    // ,".........v.....v..............vv.................."
    // ,"................v..v..v.........v....v.......v...."
    // ,"........v.....v.............v......v.v............"
    // ,"...........v....................v.v....v.v.v...v.."
    // ,"...........v......................v...v..........."
    // ,"..........vv...........v.v.....................v.."
    // ,".....................v......v............v...v...."
    // ,".....vv..........................vv.v.....v.v....."
    // ,".vv.......v...............v.......v..v.....v......"
    // ,"............v................v..........v....v...."
    // ,"................vv...v............................"
    // ,"................v...........v........v...v....v..."
    // ,"..v...v...v.............v...v........v....v..v...."
    // ,"......v..v.......v........v..v....vv.............."
    // ,"...........v..........v........v.v................"
    // ,"v.v......v................v....................v.."
    // ,".v........v................................v......"
    // ,"............................v...v.......v........."
    // ,"........................vv.v..............v...vv.."
    // ,".......................vv........v.............v.."
    // ,"...v.............v.........................v......"
    // ,"....v......vv...........................v........."
    // ,"....vv....v................v...vv..............v.."
    // ,".................................................."
    // ,"vv........v...v..v.....v..v..................v...."
    // ,".........v..............v.vv.v.............v......"
    // ,".......v.....v......v...............v............."
    // ,"..v..................v................v....v......"
    // ,".....v.....v.....................v.v......v......."}
    // 3
    //
    // Returns: 797922654
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
