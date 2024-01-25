import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] wantColors = new int[n + 1];
        int[] nowColors = new int[n + 1];


        List<Integer>[] tree = new List[n + 1]; // 트리 정보를 담기 위한 리스트 배열
        String[] colorString = reader.readLine().split(" ");
        // 각 노드별 원하는 색깔 넣기 & 각 노드별 연결리스트 생성해주기
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
            wantColors[i] = Integer.parseInt(colorString[i - 1]);
        }

        // 노드 정보 받기
        for (int i = 1; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            tree[u].add(v);
            tree[v].add(u);
        }

        boolean[] visited = new boolean[n + 1]; // 노드를 색칠하면서 이미 칠한지 안칠한지 확인하기 위한 배열
        // 초기 카운트값
        count = 0;

        paint(tree, wantColors, nowColors, visited, 1);
        System.out.println(count);
    }

    // 카운트하는 메소드
    public static void paint(List<Integer>[] tree, int[] wantColors, int[] nowColors, boolean[] visited, int node) {
        visited[node] = true;
        // 원하는 컬러로 바꾸고
        if (nowColors[node] != wantColors[node]) {
            nowColors[node] = wantColors[node];
            count++;
        }
        for (int neighbor : tree[node]) {
            // 방문 안한 노드
            if(!visited[neighbor]) {
                nowColors[neighbor] = nowColors[node]; // 자식 같은색으로 칠하기 -> 카운트 안함, 흰색이면 어차피 흰색
                paint(tree, wantColors, nowColors, visited, neighbor);
            }
        }
    }
}
