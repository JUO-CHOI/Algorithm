import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int row = 0;
        int column = 0;
        int max = -1;

        // 배열 채워넣기
        for (int i = 0; i < 9; i++) {
            String[] inputLineArray = reader.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(inputLineArray[j]);
                if (num > max) {
                    max = num;
                    row = i + 1;
                    column = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(row + " " + column);
    }
}
