import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        check(reader);


    }

    public static void check(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        String cards = reader.readLine();
        Set<String> cardsSet = new HashSet<>(Arrays.asList(cards.split(" ")));

        int m = Integer.parseInt(reader.readLine());
        String targets = reader.readLine();
        String[] targetsArray = targets.split(" ");

        int[] result = new int[m];
        Arrays.fill(result, 0);

        for (int i = 0; i < m; i++) {
            if (cardsSet.contains(targetsArray[i])) {
                result[i] = 1;
            }
            System.out.print(result[i] + " ");
        }
    }
}
