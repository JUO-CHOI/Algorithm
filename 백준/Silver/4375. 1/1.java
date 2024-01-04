import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            check(n);
        }
    }

    // (a + b) % c = {(a % c) + (b % c)} % c
    // -> 111 % 3 = (110 + 1) % 3 = (11 % 3 * 10 + 1) % 3
    // x % n = (x % n) % n
    public static void check(int n) {
        int num = 0;
        for (int i = 1; ; i++) {
            num = (num * 10 + 1) % n;
            if (num == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}

