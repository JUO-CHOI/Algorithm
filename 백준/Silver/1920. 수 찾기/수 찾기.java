import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] inputN = reader.readLine().split(" ");

        int[] intN = new int[n];
        for (int i = 0; i < n; i++) {
            intN[i] = Integer.parseInt(inputN[i]);
        }

        int m = Integer.parseInt(reader.readLine());
        String[] inputM = reader.readLine().split(" ");

        int[] intM = new int[m];
        for (int i = 0; i < m; i++) {
            intM[i] = Integer.parseInt(inputM[i]);
        }

        Arrays.sort(intN);

        int temp;

        for (int i = 0; i < m; i++) {
            temp = Arrays.binarySearch(intN, intM[i]);

            if (temp >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
