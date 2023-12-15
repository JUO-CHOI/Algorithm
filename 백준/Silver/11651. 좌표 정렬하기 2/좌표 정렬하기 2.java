import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] twoDimensionArr = new int[n][2];
        int[][] tmp = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            twoDimensionArr[i][0] = Integer.parseInt(input[0]);
            twoDimensionArr[i][1] = Integer.parseInt(input[1]);
        }

        mergeSort(twoDimensionArr, tmp, 0, n - 1);
        for (int[] raw : twoDimensionArr) {
            System.out.println(raw[0] + " " + raw[1]);
        }

    }

    public static void mergeSort(int[][] arr, int[][] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    public static void merge(int[][] arr, int[][] tmp, int start, int mid, int end) {
        // 임시 배열에 값 넣어주기
        for (int i = start; i <= end; i++) {
            tmp[i][0] = arr[i][0];
            tmp[i][1] = arr[i][1];
        }

        // 인덱스
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        // 더 큰거 찾아서 넣어주기
        while (part1 <= mid && part2 <= end) {
            // y좌표 같음
            if (tmp[part1][1] == tmp[part2][1]) {
                // 앞 조각 x가 더 작음
                if (tmp[part1][0] <= tmp[part2][0]) {
                    arr[index][0] = tmp[part1][0];
                    arr[index][1] = tmp[part1][1];
                    part1++;
                }
                else {
                    arr[index][0] = tmp[part2][0];
                    arr[index][1] = tmp[part2][1];
                    part2++;
                }
            }
            // 앞 조각이 y좌표 더 작음
            else if (tmp[part1][1] < tmp[part2][1]) {
                arr[index][0] = tmp[part1][0];
                arr[index][1] = tmp[part1][1];
                part1++;
            }
            // 뒷 조각이 y좌표 더 작음
            else {
                arr[index][0] = tmp[part2][0];
                arr[index][1] = tmp[part2][1];
                part2++;
            }
            index++;
        }
        // 앞조각 못넣은거 넣어주기, 뒷조각은 이미 정렬된 상태이므로 복사할 필요 없음
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i][0] = tmp[part1 + i][0];
            arr[index + i][1] = tmp[part1 + i][1];
        }
    }
}
