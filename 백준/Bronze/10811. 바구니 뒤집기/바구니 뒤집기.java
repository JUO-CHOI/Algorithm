import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        int[] arry = new int[N];

        for (int i = 0; i < N; i++) {
            arry[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < (second - first + 1) / 2; j++) {
                int temp = arry[second - 1 - j];
                // System.out.println(temp);
                arry[second - 1 - j] = arry[first -1 + j];
                arry[first - 1 + j] = temp;
            }
        }

        for (int i : arry) {
            System.out.print(i + " ");
        }
    }
}
