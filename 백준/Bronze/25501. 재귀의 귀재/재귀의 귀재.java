import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        String[] arry = new String[T];

        for (int i = 0; i < T; i++) {
            arry[i]  = scanner.nextLine();
        }

        for (int i = 0; i < T; i++) {
            int count = 0;
            System.out.println(isPalindrome(arry[i], arry[i].length() - 1, 0, count));
        }
    }

    public static int isPalindrome(String S, int l, int r, int count) {
        count++;
        if (r + 1 > l) {
            System.out.print(1 + " ");
            return count;
        }
        else if (S.charAt(l) != S.charAt(r)) {
            System.out.print(0 + " ");
            return count;
        }
        return isPalindrome(S, l - 1, r + 1, count);
    }
}
