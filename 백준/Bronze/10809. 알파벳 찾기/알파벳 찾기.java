import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int[] array = new int[26];

        // 초기값 -1로 채워넣기
        // Arrays.fill(array, -1);
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }

        // str의 각 글자별 위치 지정하기
        // 처음 등장하는 위치이므로 등장하지 않았다면 해당 글자는 -1인 상태
        for (int i = 0; i < str.length(); i++) {
            // 각 글자 가져오기
            char c = str.charAt(i);

            // 해당 글자의 인덱스 : c - 'a'
            // 해당 인덱스의 배열값이 -1 : 아직 등장 안함 -> 지금 위치 넣어주자
            if (array[c - 'a'] == -1) {
                array[c - 'a'] = i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
