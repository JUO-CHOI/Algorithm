import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 배열 크기 입력받기
        String[] arraySize = reader.readLine().split(" ");
        int n = Integer.parseInt(arraySize[0]);
        int m = Integer.parseInt(arraySize[1]);

        // 배열 생성
        int[][] answer = new int[n][m];

        // 배열 입력받으면서 더하기
        for (int i = 0; i < n; i++) {
            String[] inputNum = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                answer[i][j] = Integer.parseInt(inputNum[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            String[] inputNum = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                answer[i][j] += Integer.parseInt(inputNum[j]);
            }
        }

        // 배열 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(answer[i][j]);
                if (j < m - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
