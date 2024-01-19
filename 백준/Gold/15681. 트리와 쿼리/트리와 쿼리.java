import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNums = reader.readLine().split(" ");
        int n = Integer.parseInt(inputNums[0]); // 트리 정점 수
        int r = Integer.parseInt(inputNums[1]); // 루트 번호
        int q = Integer.parseInt(inputNums[2]); // 쿼리 수
        List<Integer>[] tree = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < n - 1; i++) {
            String[] nodes = reader.readLine().split(" ");
            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);
            tree[u].add(v);
            tree[v].add(u);
        }

        // 각 정점에 대한 서브트리 크기 계산
        int[] subtreeSizes = new int[n + 1];
        dfs(tree, r, subtreeSizes);

        // 쿼리에 대한 답 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int queryVertex = Integer.parseInt(reader.readLine());
            sb.append(subtreeSizes[queryVertex]).append("\n");
        }

        String answer = sb.toString();
        System.out.println(answer);
        reader.close();
    }

    private static void dfs(List<Integer>[] tree, int current, int[] subtreeSizes) {
        subtreeSizes[current] = 1; // 현재 정점을 루트로 하는 서브트리 크기 초기화

        for (int neighbor : tree[current]) {
            if (subtreeSizes[neighbor] == 0) {
                // 아직 방문하지 않은 이웃 정점에 대해 DFS 호출
                dfs(tree, neighbor, subtreeSizes);
                // 현재 정점을 루트로 하는 서브트리 크기 갱신
                subtreeSizes[current] += subtreeSizes[neighbor];
            }
        }
    }
}
