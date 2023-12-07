import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] inputArr = input.split(" ");
        int peopleNum = Integer.parseInt(inputArr[0]);
        int start = Integer.parseInt(inputArr[1]);
        int idx = start - 1;

        List<Integer> people = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();

        // 1~N까지 사람 더해주기
        for (int i = 0; i < peopleNum; i++) {
            people.add(i + 1);
        }
        // 배열이 빌때까지 더해주기
        while (true) {
            answerList.add(people.get(idx));
            people.remove(idx);
            if (people.isEmpty())
                break;
            // 줄어든 숫자 세줌
            // 새로운 인덱스는 기존 인덱스에서 그사람이 빠졌으니 1 빼주고 숫자만큼 더해줌
            // 초과시 나머지로
            idx = (idx + start - 1) % people.size();
        }
        System.out.print("<");
        for (int i = 0; i < answerList.size(); i++) {
            if (i == answerList.size() - 1) {
                System.out.print(answerList.get(i) + ">");
            }
            else {
                System.out.print(answerList.get(i) + ", ");
            }
        }
    }
}
