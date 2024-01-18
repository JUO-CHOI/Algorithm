import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 아래 위 오 왼
    private final static int[] dx = {1, -1, 0, 0};
    private final static int[] dy = {0, 0, 1, -1};

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowColumn = reader.readLine().split(" ");

        // 행,열
        int row = Integer.parseInt(rowColumn[0]);
        int column = Integer.parseInt(rowColumn[1]);

        // 단어 맵
        char[][] map = new char[row][column];
        // 단어 26개
        boolean[] used = new boolean[26];

        // 맵 받기
        for (int i = 0; i < row; i++) {
            char[] line = reader.readLine().toCharArray();
            for (int j = 0; j < column; j++) {
                map[i][j] = line[j];
            }
        }
        used[map[0][0] - 65] = true;
        dfs(map, used, 0, 0, 1);


        System.out.println(answer);
    }

    public static void dfs(char[][] map, boolean[] used, int nowX, int nowY, int count) {
        for (int i = 0; i < 4; i++) {
            int tmpX = nowX + dx[i]; int tmpY = nowY + dy[i];
            // 맵 밖을 벗어남
            if (tmpX < 0 || tmpY < 0 || tmpX >= map.length || tmpY >= map[0].length) continue;
            // 탐색 가능 (안지나갔고, 사용하지 않은 단어)
            if (!used[map[tmpX][tmpY] - 65]) {
                used[map[tmpX][tmpY] - 65] = true;
                dfs(map, used, tmpX, tmpY, count + 1);
                used[map[tmpX][tmpY] - 65] = false;
            }
        }
        if (count > answer) {
            answer = count;
        }
    }
}
