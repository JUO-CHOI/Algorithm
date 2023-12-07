import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // 카드 담을 큐
        Queue<Integer> cards = new LinkedList<>();
        // 1 ~ N 까지 넣어줌 (1이 맨 위)
        for (int i = 0; i < n; i++) {
            cards.add(i + 1);
        }

        // 1장 남을때까지
        while (cards.size() > 1) {
            // 1. 맨 윗카드 버리기
            cards.poll();
            // 2. 그 다음 윗카드 맨 아래로 넣기
            cards.add(cards.poll());
        }

        int answer = cards.poll();

        System.out.println(answer);
    }
}
