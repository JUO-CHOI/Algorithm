import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static int count;

    public static void main(String[] args) {
        int[][] wire = {{1, 3}, {3, 2}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        solution(9, wire);
    }


    public static int solution(int n, int[][] wires) {

        int answer = n - 1;

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] used = new boolean[n + 1];

        // 각각의 노드가 연결된 노드를 넣어줄 list
        // 리스트의 0번째 인덱스는 헷갈리므로 걍 비워줌, n + 1 개 만들어준다
        for (int i = 0; i < n  + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int n1 = wires[i][0];
            int n2 = wires[i][1];

            if(!graph.get(n1).contains(n2))
                graph.get(n1).add(n2);
            if(!graph.get(n2).contains(n1))
                graph.get(n2).add(n1);
        }

        count = 0;

//         하나씩 끊어보기
        for (int i = 0; i < n - 1; i++) {
            Integer n1 = wires[i][0];
            Integer n2 = wires[i][1];

            graph.get(n1).remove(n2);
            graph.get(n2).remove(n1);

            dfs(n1, graph, used);

            int line1 = count;
            int line2 = n - 2 - count;
            System.out.println(line1 + " " + line2 + " " + count);


            answer = Math.min(Math.abs(line1 - line2), answer);

            // 다시 복구
            count = 0;
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
            Arrays.fill(used, false); // 방문했던 노드들 다시 초기화
        }

        System.out.println(answer);

        return answer;
    }

    // 그래프 탐색할 DFS -> 인접한 노드 경로 갯수 구함
    public static void dfs (int node, List<List<Integer>> graph, boolean[] used) {
        used[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!used[neighbor]) {
                count++;
                dfs(neighbor, graph, used);
            }
        }
    }
}

