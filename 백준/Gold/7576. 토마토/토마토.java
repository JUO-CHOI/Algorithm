import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private final static int[] dx = {1, -1, 0, 0};
    private final static int[] dy = {0, 0, 1, -1};
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNums = reader.readLine().split(" ");
        int row = Integer.parseInt(inputNums[1]);
        int column = Integer.parseInt(inputNums[0]);

        int[][] tomatoes = new int[row][column];
        // 익은 토마토 좌표를 담을 큐
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < column; j++) {
                tomatoes[i][j] = Integer.parseInt(input[j]);
                if (Integer.parseInt(input[j]) == 1) {
                    int[] ripeTomato = new int[]{i, j, 0};
                    queue.add(ripeTomato);
                }
            }
        }
        bfs(tomatoes, queue);
        System.out.println(answer);
    }

    public static void bfs(int[][] tomatoes, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] ripeTomato = queue.poll();
            int row = ripeTomato[0];
            int column = ripeTomato[1];
            answer = ripeTomato[2];

            for (int i = 0; i < 4; i++) {
                int nowRow = row + dx[i];
                int nowColumn = column + dy[i];
                if (nowRow < 0 || nowRow >= tomatoes.length || nowColumn < 0 || nowColumn >= tomatoes[0].length) continue;
                if (tomatoes[nowRow][nowColumn] == 0) {
                    tomatoes[nowRow][nowColumn] = 1;
                    queue.add(new int[]{nowRow, nowColumn, answer + 1});
                }
            }
        }
        for (int i = 0; i < tomatoes.length; i++) {
            for (int j = 0; j < tomatoes[0].length; j++) {
                if (tomatoes[i][j] == 0) {
                    answer = -1;
                    return;
                }
            }
        }
    }
}
