package Lab07.pack;

public class EqualSubsets_650909 {
    public static boolean canPartition_Recurse(int[] arr) {
        if (arr == null) {
            return false;
        }
        if (arr.length == 0) {
            return true;
        }

        int total = 0;
        for (int num : arr) {
            total += num;
        }

        if ((total & 1) == 1) {
            return false;
        }

        return recurse(arr, 0, total / 2);
    }

    public static boolean canPartition_Memoiz(int[] arr) {
        if (arr == null) {
            return false;
        }
        if (arr.length == 0) {
            return true;
        }

        int total = 0;
        for (int num : arr) {
            total += num;
        }

        if ((total & 1) == 1) {
            return false;
        }

        int target = total / 2;
        Boolean[][] memo = new Boolean[arr.length][target + 1];
        return memoize(arr, 0, target, memo);
    }

    public static boolean canPartition_DP(int [] arr) {
        if (arr == null) {
            return false;
        }
        if (arr.length == 0) {
            return true;
        }

        int total = 0;
        for (int num : arr) {
            total += num;
        }

        if ((total & 1) == 1) {
            return false;
        }

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        return dp[target];
    }

    private static boolean recurse(int[] arr, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == arr.length || target < 0) {
            return false;
        }

        if (recurse(arr, index + 1, target - arr[index])) {
            return true;
        }

        return recurse(arr, index + 1, target);
    }

    private static boolean memoize(int[] arr, int index, int target, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }
        if (index == arr.length || target < 0) {
            return false;
        }
        if (memo[index][target] != null) {
            return memo[index][target];
        }

        boolean include = memoize(arr, index + 1, target - arr[index], memo);
        boolean exclude = memoize(arr, index + 1, target, memo);

        memo[index][target] = include || exclude;
        return memo[index][target];
    }
}
