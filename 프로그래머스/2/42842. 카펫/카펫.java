class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int row = 0;
        int col = 0;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) continue;
            col = i + 2;
            row = yellow / i + 2;

            if ((row * col - yellow) == brown) {
                answer[0] = row;
                answer[1] = col;
                break;
            }
        }

        System.out.println(row);
        System.out.println(col);
        return answer;
    }
}