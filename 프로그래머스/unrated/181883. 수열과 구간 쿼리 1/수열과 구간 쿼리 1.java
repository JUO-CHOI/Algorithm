class Solution {
public int[] solution(int[] arr, int[][] queries) {
        int n = queries.length;
        int m = 2;
        for (int i = 0; i < n; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            for (int j = s; j <= e; j++) {
                    arr[j] += 1;
            }
        }
        return arr;
    }
}