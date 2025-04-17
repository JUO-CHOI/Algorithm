import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        
        // 좌우 비교하기
        int answer = 1;
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) == input.charAt(right)) {
                left++;
                right--;
            } else {
                answer = 0;
                break;
            }
        }

        System.out.println(answer);
    }
}
