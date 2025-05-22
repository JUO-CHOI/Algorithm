import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[][] points = new int[n][2];

        String[] inputPoint;
        for (int i = 0; i < n; i++) {
            inputPoint = reader.readLine().split(" ");
            points[i][0] = Integer.parseInt(inputPoint[0]); // X
            points[i][1] = Integer.parseInt(inputPoint[1]); // Y
        }

        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < n; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }
}