import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 손님수N과 초밥수M 받자
        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 손님 수
        int M = Integer.parseInt(input[1]); // 만들 초밥 갯수

        // 초밥과 그 초밥을 먹고싶은 손님 큐를 Map으로 만들자
        // 이때 매번 입력을 parseInt해주기 귀찮으니 스트링으로 받자
        Map<String, Queue<Integer>> sushi = new HashMap<>();

        // N명의 손님에게 먹고싶은 초밥의 정보를 받자
        for (int i = 0; i < N; i++) {
            String[] order = reader.readLine().split(" ");
            for (int j = 0; j < Integer.parseInt(order[0]); j++) {
                if (sushi.get(order[j + 1]) == null) {
                    sushi.put(order[j + 1], new LinkedList<>());
                }
                sushi.get(order[j + 1]).add(i);
            }
        }

        String[] madeSushi = reader.readLine().split(" ");
        int[] count = new int[N];

        for (int i = 0; i < M; i++) {
            if (sushi.get(madeSushi[i]) == null || sushi.get(madeSushi[i]).isEmpty()) continue;
            int eatPerson = sushi.get(madeSushi[i]).poll();
            count[eatPerson] += 1;
        }

        for (int num : count) {
            System.out.print(num + " ");
        }
    }
}
