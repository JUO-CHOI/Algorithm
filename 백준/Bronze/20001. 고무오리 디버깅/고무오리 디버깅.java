import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 고무오리 디버깅 시작
        String input = reader.readLine();

        // 문제와 고무오리 카운트
        int quiz = 0;
        while (true) {
            input = reader.readLine();
            // 종료 조건
            if (input.equals("고무오리 디버깅 끝")) {
                break;
            }
            if (input.equals("문제")) {
                quiz++;
            }
            if (input.equals("고무오리")) {
                if (quiz <= 0) {
                    quiz += 2;
                } else {
                    quiz--;
                }
            }
        }

        if (quiz > 0) {
            System.out.println("힝구");
        } else {
            System.out.println("고무오리야 사랑해");
        }
    }
}
