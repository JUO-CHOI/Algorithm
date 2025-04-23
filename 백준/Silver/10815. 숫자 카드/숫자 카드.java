import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] input1 = reader.readLine().split(" "); // 상근이가 가진 카드 입력
        boolean[] s = new boolean[20000001];
        Arrays.fill(s, false);

        for (int i = 0; i < input1.length; i++) {
            s[Integer.parseInt(input1[i]) + 10000000] = true;
        }

        int m = Integer.parseInt(reader.readLine());
        String[] input2 = reader.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input2.length; i++) {
            if (s[Integer.parseInt(input2[i])+ 10000000]) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.print(sb);
    }
}
