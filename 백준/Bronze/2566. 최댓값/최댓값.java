import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int xIndex = 0;
        int yIndex = 0;

        for (int i = 0; i < 9; i++) {
            String[] strNum = reader.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(strNum[j]);
                if (num > max) {
                    xIndex = i;
                    yIndex = j;
                    max = num;
                }
            }
        }

        System.out.println(max);
        System.out.println(String.format("%d %d", xIndex + 1, yIndex + 1));
    }
}
