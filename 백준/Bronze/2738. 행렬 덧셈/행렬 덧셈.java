import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        String[] dimensionNum = num.split(" ");
        int n = Integer.parseInt(dimensionNum[0]);
        int m = Integer.parseInt(dimensionNum[1]);

        int[][] A = new int[n][m];
        int[][] B = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] inputNumArray = input.split(" ");
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(inputNumArray[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] inputNumArray = input.split(" ");
            for (int j = 0; j < m; j++) {
                B[i][j] = Integer.parseInt(inputNumArray[j]);
            }
        }

        int [][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = A[i][j] + B[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
