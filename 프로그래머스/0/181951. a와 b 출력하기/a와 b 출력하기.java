import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        StringTokenizer st = new StringTokenizer(input);
        int count = st.countTokens();

        for (int i = 0; i < count; i++) {
            char c = (char) ('a' + i);
            System.out.println(c + " = " + st.nextToken());
        }
    }
}