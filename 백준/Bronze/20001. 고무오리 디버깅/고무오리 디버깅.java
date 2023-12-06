
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        rubberDuck(reader);
    }

    public static void rubberDuck(BufferedReader reader) throws IOException {
        reader.readLine(); // 첫줄 고무오리 디버깅 시작
        Stack<Integer> prob = new Stack<>();
        boolean flag = true;
        while (flag) {
            String input = reader.readLine();

            switch (input) {
                case "문제" :
                    prob.push(1);
                    break;
                case "고무오리" :
                    if (prob.isEmpty()) {
                        prob.push(1);
                        prob.push(1);
                    }
                    else prob.pop();
                    break;
                case "고무오리 디버깅 끝" :
                    flag = false;
                    break;
            }
        }
        if (prob.isEmpty())
            System.out.print("고무오리야 사랑해");
        else
            System.out.print("힝구");
    }
}
