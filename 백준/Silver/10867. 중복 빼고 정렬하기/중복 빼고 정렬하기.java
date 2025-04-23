import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] inputNum = reader.readLine().split(" ");
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hashSet.add(Integer.parseInt(inputNum[i]));
        }

        Integer[] answer = hashSet.toArray(new Integer[0]);
        Arrays.sort(answer, Comparator.comparingInt(i -> i));

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
