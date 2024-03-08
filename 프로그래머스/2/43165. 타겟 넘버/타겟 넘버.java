public class Solution {
    private static int count;

    public static int solution(int[] numbers, int target) {
        count = 0;
        recursive(0, 0, numbers.length, numbers, target);

        return count;
    }

    public static void recursive(int sum, int depth, int n, int[] numbers, int target) {
        if (depth == n) {
            if (sum == target) {
                count++;
            }
        }
        else {
            recursive(sum + numbers[depth], depth + 1, n, numbers, target);
            recursive(sum - numbers[depth], depth + 1, n, numbers, target);
        }
    }
}
