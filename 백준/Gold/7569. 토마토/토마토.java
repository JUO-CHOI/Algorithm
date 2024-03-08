import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int n, m, h;
    private static int[][][] tomatoes;
    private static Queue<int[]> queue = new LinkedList<>();

    // 여섯 방향의 델타
    private final static int[] dx = {1, -1, 0, 0, 0, 0};
    private final static int[] dy = {0, 0, 1, -1, 0, 0};
    private final static int[] dz = {0, 0, 0, 0, 1, -1};

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNums = reader.readLine().split(" ");
        m = Integer.parseInt(inputNums[0]);
        n = Integer.parseInt(inputNums[1]);
        h = Integer.parseInt(inputNums[2]);

        tomatoes = new int[h][n][m];

        // 토마토 채우기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String[] inputLine = reader.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(inputLine[k]);
                    // 익은 토마토를 큐에 넣어두기
                    if (Integer.parseInt(inputLine[k]) == 1) {
                        // H, N, M 순으로 추가
                        queue.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }
            bfs();
            System.out.println(answer());
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] nowTomato = queue.poll();
            int nowH = nowTomato[0];
            int nowN = nowTomato[1];
            int nowM = nowTomato[2];
            int nowDay = nowTomato[3];

            // 익는게 가장 오래 걸린 토마토
            if (nowDay > answer) {
                answer = nowDay;
            }

            // 여섯방향 체크
            for (int i = 0; i < 6; i++) {
                boolean possible = check(nowN, nowM, nowH, i);
                if (possible) {
                    int nextN = nowN + dx[i];
                    int nextM = nowM + dy[i];
                    int nextH = nowH + dz[i];
                    tomatoes[nextH][nextN][nextM] = 1;
                    queue.add(new int[]{nextH, nextN, nextM, nowDay + 1});
                }
            }
        }
    }

    public static boolean check(int nowN, int nowM, int nowH, int i) {
        int nextN = nowN + dx[i];
        int nextM = nowM + dy[i];
        int nextH = nowH + dz[i];
        // 1. 범위 벗어나면 패스
        if (nextN < 0 || nextN >= n || nextM < 0 || nextM >= m || nextH < 0 || nextH >= h)
            return false;
        // 안익은 토마토는 true, 없거나 이미 익었으면 false
        if (tomatoes[nextH][nextN][nextM] == 0)
            return true;
        else
            return false;
    }

    // 안익은 토마토가 있다면 틀림
    public static int answer() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }
        return answer;
    }
}
