import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();

        int[] arry = new int[26];
        Arrays.fill(arry, -1);

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (arry[c - 'a'] == -1) {
                arry[c - 'a'] = i;
            }
        }

        for (int i : arry) {
            System.out.print(i + " ");
        }
    }
}
