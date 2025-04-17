import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // M와 N 입력받기
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // N 크기의 바구니 배열 만들기
        int[] baskets = new int[m];
        for (int i = 0; i < m; i++) {
            baskets[i] = i + 1;
        }

        // N번만큼 수행하기
        for (int i = 0; i < n; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            reverse(baskets, left, right);
        }

        // 출력하기
        for (int i = 0; i < m; i++) {
            System.out.print(baskets[i] + " ");
        }
    }

    // 배열은 참조형이기 때문에 메서드에서 배열 값을 바꾸면 원본 배열도 바뀜 -> 굳이 리턴 안해도 된다
    public static void reverse(int[] baskets, int left, int right) {
        // 값 뒤집기
        while (left < right) {
            int temp = baskets[left - 1];
            baskets[left - 1] = baskets[right - 1];
            baskets[right - 1] = temp;
            left++;
            right--;
        }
    }
}
