import java.lang.CharSequence;

public class Solution {

    public static String solution(int[] numbers) {
        int[] tmp = new int[numbers.length];

        sort(numbers,tmp, 0, numbers.length - 1);

        StringBuilder sb = new StringBuilder();

        for (int num : numbers) {
            sb.append(num);
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }
        else return sb.toString();
    
    }

    public static void sort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, tmp, start, mid);
            sort(arr, tmp, mid + 1, end);
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
            if (Integer.parseInt(Integer.toString(tmp[part1]).substring(0, 1)) == Integer.parseInt(Integer.toString(tmp[part2]).substring(0, 1))) {
                String pt1pt2 = Integer.toString(tmp[part1]) +  Integer.toString(tmp[part2]);
                String pt2pt1 = Integer.toString(tmp[part2]) +  Integer.toString(tmp[part1]);
                if (Integer.parseInt(pt1pt2) >= Integer.parseInt(pt2pt1)) {
                    arr[index] = tmp[part1];
                    part1++;
                }
                else {
                    arr[index] = tmp[part2];
                    part2++;
                }
            }
            else if (Integer.parseInt(Integer.toString(tmp[part1]).substring(0, 1)) < Integer.parseInt(Integer.toString(tmp[part2]).substring(0, 1))) {
                arr[index] = tmp[part2];
                part2++;
            }
            else {
                arr[index] = tmp[part1];
                part1++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }
}
