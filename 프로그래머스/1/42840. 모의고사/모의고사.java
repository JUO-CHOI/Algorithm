class Solution {
public static int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == student1[i % student1.length]) answer1++;
            if (answer == student2[i % student2.length]) answer2++;
            if (answer == student3[i % student3.length]) answer3++;
        }

        int max = Math.max(Math.max(answer1, answer2), answer3);
        StringBuilder sb = new StringBuilder();

        if (answer1 == max) sb.append(1);
        if (answer2 == max) sb.append(2);
        if (answer3 == max) sb.append(3);

        String[] stringArr = sb.toString().split("");
        int[] answer = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            answer[i] = Integer.parseInt(stringArr[i]);
        }
        
        return answer;
    }
}