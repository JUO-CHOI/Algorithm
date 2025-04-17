import java.util.Scanner;

public class Main {
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // M와 N 입력받기
        String input = scanner.nextLine();
        String[] mn = input.split(" ");
        m = Integer.parseInt(mn[0]);
        n = Integer.parseInt(mn[1]);

        // N 크기의 바구니 배열 만들기
        int[] baskets = new int[m];
        for (int i = 0; i < m; i++) {
            baskets[i] = i + 1;
        }

        // N번만큼 수행하기
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            mn = input.split(" ");
            int from = Integer.parseInt(mn[0]);
            int to = Integer.parseInt(mn[1]);

            baskets = reverse(baskets, from, to);
        }

        // 출력하기
        for (int i = 0; i < m; i++) {
            System.out.print(baskets[i] + " ");
        }
    }

    public static int[] reverse(int[] baskets, int from, int to) {
        // 임시 배열 만들기
        int[] reverseBaskets = new int[baskets.length];
        for (int i = 0; i < reverseBaskets.length; i++) {
            reverseBaskets[i] = baskets[i];
        }

        // 시행할 횟수
        int count = to - from + 1;

        // 값 뒤집기
        for (int i = 0; i < count; i++) {
            reverseBaskets[to - i - 1] = baskets[from + i - 1];
        }

        return reverseBaskets;
    }
}
