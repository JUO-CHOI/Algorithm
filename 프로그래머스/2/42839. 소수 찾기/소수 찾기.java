import java.util.*;

public class Solution {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        solution("011");

    }

    public static int solution(String numbers) {
        String[] arr =  numbers.split("");
        int[] numArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }

        boolean[] used = new boolean[numArr.length];
        int[] perm = new int[numArr.length];

        for (int i = 1; i <= numArr.length; i++) {
            permRecursive(numArr, numArr.length, i, 0, used, perm);
        }

        System.out.println(set);
        return set.size();
    }

    public static void permRecursive(int[] numArr, int n, int r, int depth, boolean[] used, int[] perm) {
        if (depth == r) {
            String string = "";

            for (int i = 0; i < r; i++) {
                string += perm[i];
            }

            if (!string.isEmpty()) {
                int num = Integer.parseInt(string);
                System.out.println(num);

                if (check(num)) {
                    set.add(num);
                }
            }

        }
        else {
            for (int i = 0; i < n; i++) {
                if (used[i]) continue;

                perm[depth] = numArr[i];
                used[i] = true;
                permRecursive(numArr, n, r, depth + 1, used, perm);
                used[i] = false;
            }
        }
    }

    public static boolean check(int num) {
        // 1은 소수가 아님
        if (num < 2) return false;
        // 2 이상, 자기 자신보다 작은 숫자로 나눠지면 소수가 아님
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
