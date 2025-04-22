import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int isPalindrome;
    static int palindromeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 테스트케이스 개수
        int t = Integer.parseInt(reader.readLine());
        String[] inputs = new String[t];

        for (int i = 0; i < t; i++) {
            inputs[i] = reader.readLine();
        }

        for (int i = 0; i < t; i++) {
            recursion(inputs[i], 0, inputs[i].length() - 1, 1);
            System.out.println(isPalindrome + " " + palindromeCount);
        }
    }

    public static void recursion(String input, int left, int right, int count) {
        if (left >= right) { // 문제없이 좌우가 만남 -> 팰린드롬
            isPalindrome = 1;
            palindromeCount = count;
            return;
        }
        else if (input.charAt(left) != input.charAt(right)) { // 중간에 글자가 다름 -> 팰린드롬 아님
            isPalindrome = 0;
            palindromeCount = count;
            return;
        }

        // 일단 현재까지 좌우 같음 -> 좌우 한칸씩 이동하고 다시 검사
        recursion(input, left + 1, right - 1, count + 1);
    }
}
