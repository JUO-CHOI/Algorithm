import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // 효율성 떨어짐
        // Scanner scanner = new Scanner(System.in);
        // 어떤 입력에 대하여 버퍼링 기능 제공. 실제론 파일입출력뿐만 아니라 다양하게 사용
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String[] answer = answer(input);
        for (String num : answer) {
            System.out.print(num + " ");
        }
    }

    public static String[] answer(String whiteString) {
        int[] black = {1, 1, 2, 2, 2, 8};
        String[] answer = whiteString.split(" "); // 주어진 인자를 (정규 표현식으로 활용해서) 기준으로 삼아

        int sum = 0;
        for (int i = 0; i < black.length; i++) {
            answer[i] = Integer.toString(black[i] - Integer.parseInt(answer[i]));
        }
        return answer;
    }
}
