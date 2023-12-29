public class Solution {

    private static int[][] perm;
    private static boolean[] used;
    private static int max;

    public static void main(String[] args) {
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(80, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        perm = new int[dungeons.length][2];
        used = new boolean[dungeons.length];
        max = 0;

        permRecursive(dungeons, k, 0);

        return max;
    }

    public static void permRecursive(int[][] dungeons, int k, int depth) {
        if (depth == dungeons.length) {
            int count = check(k, perm);
            if (count > max) {
                max = count;
            }
        }
        else {
            for (int i = 0; i < dungeons.length; i++) {
                if (used[i]) continue;
                perm[depth] = dungeons[i];
                used[i] = true;
                permRecursive(dungeons, k, depth + 1);
                used[i] = false;
            }
        }
    }

    public static int check(int k, int[][] dungeons) {
        int count = 0;
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0]) {
                k -= dungeons[i][1];
                count++;
            }
        }
        return count;
    }
}
