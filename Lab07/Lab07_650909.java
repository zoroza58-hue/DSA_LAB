package Lab07;

import Lab07.pack.EqualSubsets_650909;
import Lab07.pack.GridPaths_650909;

public class Lab07_650909 {
    static void task_01() {
        int[] a = {1, 5, 11, 5};
        int[] b = {1, 5, 30};
        int[] c = {1, 2, 3, 5};

        System.out.println(EqualSubsets_650909.canPartition_Recurse(a));
        System.out.println( EqualSubsets_650909.canPartition_Memoiz(a) );
        System.out.println( EqualSubsets_650909.canPartition_DP(a) );
        System.out.println( EqualSubsets_650909.canPartition_Recurse(b) );
        System.out.println( EqualSubsets_650909.canPartition_Memoiz(b) );
        System.out.println( EqualSubsets_650909.canPartition_DP(b) );
        System.out.println( EqualSubsets_650909.canPartition_Recurse(c) );
        System.out.println( EqualSubsets_650909.canPartition_Memoiz(c) );
        System.out.println( EqualSubsets_650909.canPartition_DP(c) );
    }

    static void task_02() {
        int [][] grid = { {0,0,0,0},
                        {0,1,0,0},
                        {0,0,0,1},
                        {1,0,0,0} };
        GridPaths_650909 sol = new GridPaths_650909();
        System.out.println("--- grid path ---");
        System.out.println("number of paths: " + sol.numberOfPaths(grid) );
    }

    public static void main(String[] args) {
        task_01();
        task_02();
    }
}
