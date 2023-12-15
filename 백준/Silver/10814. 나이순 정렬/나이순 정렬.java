import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // 나이, 이름 저장 (나이는 우선 String으로 저장 후 비교 시 int로 변환
        String[][] members = new String[n][2];
        String[][] tmp = new String[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            members[i][0] = input[0];
            members[i][1] = input[1];
        }

        mergeSort(members, tmp, 0, n - 1);

        StringBuilder sb = new StringBuilder();

        for (String[] line : members) {
            sb.append(line[0]).append(" ").append(line[1]).append("\n");
        }

        System.out.println(sb.toString());

        reader.close();
    }

    public static void mergeSort(String[][] arr, String[][] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    public static void merge(String[][] arr, String[][] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i][0] = arr[i][0];
            tmp[i][1] = arr[i][1];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            // 나이가 같으면 앞 배열의 사람 넣어줌
            if (Integer.parseInt(tmp[part1][0]) == Integer.parseInt(tmp[part2][0])) {
                arr[index][0] = tmp[part1][0];
                arr[index][1] = tmp[part1][1];
                part1++;
            }
            // 어린사람 넣어줌
            else if (Integer.parseInt(tmp[part1][0]) < Integer.parseInt(tmp[part2][0])) {
                arr[index][0] = tmp[part1][0];
                arr[index][1] = tmp[part1][1];
                part1++;
            }
            else {
                arr[index][0] = tmp[part2][0];
                arr[index][1] = tmp[part2][1];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i][0] = tmp[part1 + i][0];
            arr[index + i][1] = tmp[part1 + i][1];
        }
    }
}