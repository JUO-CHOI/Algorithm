import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int min = 0;
        int max = 0;
        int[] answer = new int[2];
        // 맞춘개수, 등수 담은 배열
        int[][] rank = {{6, 1}, {5, 2}, {4, 3}, {3, 4}, {2, 5}, {1, 6}, {0, 6}};

        for (int num : lottos) {
            for (int win_num : win_nums) {
                if (num == win_num) min++;
            }
            if (num == 0) max++;
        }

        max += min;

        for (int i = 0; i < rank.length; i++) {
            if (rank[i][0] == min) {
                answer[1] = rank[i][1];
            }
            if (rank[i][0] == max) {
                answer[0] = rank[i][1];
            }
        }

        return answer;
    }
}
