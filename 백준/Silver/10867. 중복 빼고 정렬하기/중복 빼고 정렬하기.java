import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        String[] input = reader.readLine().split(" ");
        int[] nums = new int[n];
        int[] tmp = new int[n];
        int count = 0;
        for (String num : input) {
            nums[count] = Integer.parseInt(num);
            count++;
        }
        mergeSort(nums, tmp, 0, n - 1);

        count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i !=0 && nums[i - 1] == nums[i]) {
                count++;
                continue;
            }
            tmp[j] = nums[i];
            j++;
        }

        for (int i = 0; i < n - count; i++) {
            System.out.print(tmp[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    public static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
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
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++ ) {
            arr[index + i] = tmp[part1 + i];
        }
    }
}
