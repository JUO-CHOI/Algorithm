import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // N 받기
        int n = Integer.parseInt(reader.readLine());

        // 일렬로 세우고 mergesort 하자
        int[] arr = new int[n * n];
        int[] tmp = new int[n * n];

        // 입력 받기
        int index = 0;
        for (int i = 0; i < n; i++) {
            String[] inputLine = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[index] = Integer.parseInt(inputLine[j]);
                index++;
            }
        }

        mergeSort(0, arr.length - 1, arr, tmp);

        System.out.println(arr[n -1]);
    }

    public static void mergeSort(int start, int end, int[] arr, int[] tmp) {
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

    public static void merge(int start, int mid, int end, int[] arr, int[] tmp) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] >= tmp[part2]) {
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
