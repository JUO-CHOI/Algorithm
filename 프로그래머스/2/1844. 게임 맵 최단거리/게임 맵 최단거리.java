import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    // 좌표 이동을 위한 값. 순서대로 남북동서
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int n;
    private static int m;



    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        System.out.println(solution(maps));
    }


    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        return bfs(0, 0, maps);
    }

    public static int bfs(int x, int y, int[][] maps) {
        int answer = -1;

        // BFS에 사용할 큐
        Queue<int[]> queue = new LinkedList<>();
        // 탐색완료를 나타낼 배열
        int[][] used = new int[n][m];

        // 첫 칸 넣어주기
        queue.add(new int[]{x, y, 1});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tempX = temp[0];
            int tempY = temp[1];
            int count = temp[2];

            // 종료조건
            if (tempX == n - 1 && tempY == m - 1) {
                // return count;
                answer = count;
                break;
            }

            // 사방 탐색
            for (int i = 0; i < 4; i++) {
                // 범위 벗어나면 패스
                if (tempX + dx[i] < 0 || tempX + dx[i] >= n || tempY + dy[i] < 0 || tempY + dy[i] >= m) {
                    continue;
                }
                // 탐색 가능하면 큐에 넣기
                if (maps[tempX + dx[i]][tempY + dy[i]] == 1 && used[tempX + dx[i]][tempY + dy[i]] == 0) {
                    // 방문 완료
                    used[tempX + dx[i]][tempY + dy[i]] = 1;
                    queue.add(new int[]{tempX + dx[i], tempY + dy[i], count + 1});
                }
            }
        }
        return answer;
    }
}
