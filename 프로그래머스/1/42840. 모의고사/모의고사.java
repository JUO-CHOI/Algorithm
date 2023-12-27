import java.util.Arrays;

class Solution {
    public static int[] solution(int[] answers) {
        int[] nums = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            // 1번 답 확인
            if (checkNum1(i, answer)) {
                nums[0]++;
            }
            if (checkNum2(i, answer)) {
                nums[1]++;
            }
            if (checkNum3(i, answer)) {
                nums[2]++;
            }
        }
        int max = Math.max(Math.max(nums[0], nums[1]), nums[2]);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            if (nums[i] == max)
                sb.append(i + 1);
        }
        String[] answerString = sb.toString().split("");
        int[] answer = new int[answerString.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(answerString[i]);
        }

        return answer;
    }










    public static boolean checkNum1(int i, int answer) {
        return answer == i % 5 + 1;
    }

    public static boolean checkNum2(int i, int answer) {
        // 홀수의 경우 무조건 2
        if (i % 2 == 0) {
            return answer == 2;
        }
        else {
            int index = i % 8;
            switch (index) {
                case 1 : return answer == 1;
                case 3 : return answer == 3;
                case 5 : return answer == 4;
                case 7 : return answer == 5;
            }
        }
        return false;
    }

    public static boolean checkNum3(int i, int answer) {
        int index = i % 10;
        switch (index) {
            case 0 : return answer == 3;
            case 1 : return answer == 3;
            case 2 : return answer == 1;
            case 3 : return answer == 1;
            case 4 : return answer == 2;
            case 5 : return answer == 2;
            case 6 : return answer == 4;
            case 7 : return answer == 4;
            case 8 : return answer == 5;
            case 9 : return answer == 5;
        }
        return false;
    }
}