import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int n;
    private int m;
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        int[][] visited = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        // x, y, count
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] nowSearch = queue.poll();
            int nowX = nowSearch[0];
            int nowY = nowSearch[1];
            int nowCount = nowSearch[2];
            // 탐색했다고 추가

            // 종료조건 -> (n,m)에 도착
            if (nowX == n - 1 && nowY == m - 1) {
                return nowCount;
            }

            for (int i = 0; i < 4; i++) {
                // 다음 탐색할 좌표
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                // 맵 밖은 패스
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                // 갈 수 있다면 추가 (길이 있고, 탐색하지 않음)
                if (maps[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                    visited[nextX][nextY] = 1;
                    queue.add(new int[]{nextX, nextY, nowCount + 1});
                }
            }
        }

        // 답을 찾지 못하고 큐가 비었다 -> 갈 수 없다
        return -1;
    }
}
