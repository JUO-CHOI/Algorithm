import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        int[] arry = new int[26];

        for (int i = 0; i < arry.length; i++) {
            arry[i] = -1;
        }

        char[] charArry = S.toCharArray();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < charArry.length; j++) {
                if (charArry[j] == (char)(i+97)) {
                    arry[i] = j;
                    break;
                }
            }
            System.out.print(arry[i] + " ");
        }
    }
}