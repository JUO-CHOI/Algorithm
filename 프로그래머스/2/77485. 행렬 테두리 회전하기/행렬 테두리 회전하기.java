import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        int num = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num;
                num++;
            }
        }

       for (int i = 0; i < queries.length; i++) {
           answer[i] = rotate(queries[i], matrix);
       }

        return answer;
    }

    public static int rotate(int[] query, int[][] matrix) {
        int startM = query[0] - 1;
        int startN = query[1] - 1;

        int nextNum = matrix[startM][startN];
        int returnValue = nextNum;


        while (true) {
            int temp = nextNum;
            int checkNum = check(startM, startN, query);
            switch (checkNum) {
                case 1: startN++;
                        break;
                case 2: startM++;
                        break;
                case 3: startN--;
                        break;
                case 4: startM--;
                        break;
            }

            nextNum = matrix[startM][startN];
            if (nextNum < returnValue) {
                returnValue = nextNum;
            }
            matrix[startM][startN] = temp;

            if (startM == query[0] - 1 && startN == query[1] - 1)
                break;
        }

        return returnValue;
    }

    public static int check(int m, int n, int[] query) {
        // 윗변
        if (m == query[0] - 1 && n < query[3] - 1) {
            return 1;
        }
        // 우변
        if (m < query[2] - 1 && n == query[3] - 1) {
            return 2;
        }
        // 아랫변
        if (m == query[2] - 1 && n > query[1] - 1) {
            return 3;
        }
        // 좌변
        if (m > query[0] - 1 && n == query[1] - 1) {
            return 4;
        }
        return 0;
    }
}
