import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = reader.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        String[] cardsString = reader.readLine().split(" ");
        long[] cards = new long[n];
        long[] tmp = new long[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(cardsString[i]);
        }

        for (int i = 0; i < m; i++) {
            mergeSort(0, cards.length - 1, cards, tmp);
            long plus = cards[0] + cards[1];
            cards[0] = plus;
            cards[1] = plus;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cards[i];
        }

        System.out.println(sum);
    }

    public static void mergeSort(int start, int end, long[] arr, long[] tmp) {
        if (start < end) {
            // 중앙값
            int mid = (start + end) / 2;
            // 앞쪽 정렬
            mergeSort(start, mid, arr, tmp);
            // 뒷쪽 정렬
            mergeSort(mid + 1, end, arr, tmp);
            // 병합
            merge(start, mid, end, arr, tmp);
        }
    }

    public static void merge(int start, int mid, int end, long[] arr, long[] tmp) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            }
            else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }

        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }
}