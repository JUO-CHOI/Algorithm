import java.util.*;

class Solution {
static List<String[]> answers;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        solution(tickets);
    }

    public static String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        String[] temp = new String[tickets.length + 1];
        boolean[] used = new boolean[tickets.length];

        dfs(tickets, temp, used, "ICN", 0);


        int answerNum = 0;
        for (int i = 1; i < answers.size(); i++) {
            // 뒤에가 더 빠름
            if (compare(answers.get(answerNum), answers.get(i)) > 0) {
                answerNum = i;
            }
            // 앞이 더 빠르면 숫자 그대로 놔둠
        }

        System.out.println(Arrays.toString(answers.get(answerNum)));
        return answers.get(answerNum);
    }

    public static void dfs(String[][] tickets, String[] temp, boolean[] used, String from, int depth) {
        temp[depth] = from;
        if (depth == tickets.length) {
            String[] answer = new String[temp.length];
            for (int i = 0; i < temp.length; i++) {
                answer[i] = temp[i];
            }
            answers.add(answer);
        }

        for (int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals(from) && !used[i]) {
                used[i] = true;
                dfs(tickets, temp, used, tickets[i][1], depth + 1);
                used[i] = false;
            }
        }
    }

    // 두 배열 비교, 길이는 같다는 가정
    public static int compare(String[] a, String[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(b[i])) continue;
            // 뒤에가 더 빠름
            if (a[i].compareTo(b[i]) > 0) {
                return 1;
            }
            // 앞에가 더 빠름
            else return -1;
        }
        // 같으면 0 반환
        return 0;
    }
}