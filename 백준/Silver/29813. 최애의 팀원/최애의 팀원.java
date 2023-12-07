import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        // 학생들이 줄 설 Queue
        Queue<Student> line = new LinkedList<>();

        // 학생 정보 입력받으면 객체 생성해서 큐에 넣음
        for (int i = 0; i < N; i++) {
            String[] info = reader.readLine().split(" ");
            line.add(new Student(info[0], Integer.parseInt(info[1])));
        }

        while (line.size() > 1) {
            Student student = line.poll(); // 첫 학생 꺼냄
            for (int i = 0; i < student.num - 1; i++) {
                // n-1번까지 그냥 넣음
                line.add(line.poll());
            }
            line.poll(); // 짝 찾아서 나감
        }
        System.out.println(line.poll().name); // 마지막 남은 학생 출력
    }

    static class Student {
        String name;
        int num;

        public Student(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }
}
