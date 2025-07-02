import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }

//        Arrays.sort(nums);

        int[] temp = new int[n];

        mergeSort(0, n - 1, nums, temp);
        
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void mergeSort(int start, int end, int[] array, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid, array, temp);
            mergeSort(mid + 1, end, array, temp);
            merge(start, mid, end, array, temp);
        }
    }

    public static void  merge(int start, int mid, int end, int[] array, int[] temp) {
        int index = start;
        int part1 = start;
        int part2 = mid + 1;

        for (int i = start; i <= end; i++) {
            temp[i] = array[i];
        }

        while (part1 <= mid && part2 <= end) {
            if (temp[part1] <= temp[part2]) {
                array[index] = temp[part1];
                part1++;
            } else {
                array[index] = temp[part2];
                part2++;
            }
            index++;
        }

        while (part1 <= mid) {
            array[index] = temp[part1];
            part1++;
            index++;
        }
    }
}
